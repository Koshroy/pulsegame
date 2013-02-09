#!/usr/bin/env python
from __future__ import print_function, division
from thrift.transport import TTransport, TSocket
from thrift.protocol import TBinaryProtocol

from gen_py.game.ttypes import Pos, UnitType, Op, OpType, MoveOp, AttackOp, BuyOp
from gen_py.game import Game

import random
import time

class DesiredOp:
	# keep priorities between 0 and 100 (floats)
	def __init__(self, op, pri):
		self.op = op
		self.pri = pri
	def __le__(self, other):
		return self.pri <= other.pri

def sgn(n):
	if n > 0:
		return 1
	if n < 0:
		return -1
	return 0

def distance(p1, p2):
	return abs(p1.x - p2.x) + abs(p1.y - p2.y)

class SimpleAI:
	BUY_PRI = 50
	# management
	def __init__(self, host, port, identity, buy_prob):
		socket = TSocket.TSocket(host, port)
		transport = TTransport.TFramedTransport(socket)
		protocol = TBinaryProtocol.TBinaryProtocol(transport)
		client = Game.Client(protocol)
		self._transport = transport
		self.client = client
		transport.open()
		init = client.startGame(identity)
		if init.pid is None:
			self.pid = 0
		else:
			self.pid = init.pid
		self.tok = init.tok
		self.m = init.gameMap
		self.state = init.state
		self.buy_prob = buy_prob
	def __del__(self):
		self._transport.close()

	# asking for things (very deep object hierarchy)
	def myBase(self):
		return self.state.world.bases[self.pid]
	def enemyBase(self):
		return self.state.world.bases[1-self.pid]
	def myUnits(self):
		return self.state.world.units[self.pid]
	def enemyUnits(self):
		return self.state.world.units[1-self.pid]

	# decisions
	def unitPlace(self):
		if self.pid == 0:
			return Pos(6,6)
		else:
			return Pos(self.m.height - 6, self.m.width - 6)
	def buy(self):
		where = self.unitPlace()
		return Op(type=OpType.BUY, buy=BuyOp(type=self.bestUnit(), startPos=where))
	def move(self, up):
		dest = Pos(up.pos.x, up.pos.y)
		dest.x += sgn(self.enemyBase().pos.x - up.pos.x)
		dest.y += sgn(self.enemyBase().pos.y - up.pos.y)
		if dest == up.pos:
			return None
		return Op(type=OpType.MOVE,
				move=MoveOp(unit=up.unit,
					destination=dest)
				)
	def bestUnit(self):
		return UnitType.TYPE0
	def attack(self, me, them):
		return Op(type=OpType.ATTACK,
				attack=AttackOp(attacker=me,
					enemy=them)
				)
	def checkWeather(self):
		return Op(type=OpType.CHECK_WEATHER)

	# ops for this turn
	def requests(self):
		# build
		if self.state.user.gold > 0:
			buy = (random.uniform(0,1) < self.buy_prob)
			if buy:
				yield DesiredOp(self.buy(), SimpleAI.BUY_PRI)
		doCheckWeather = (random.uniform(0, 1) < self.buy_prob)
		#doCheckWeather = False
		if doCheckWeather:
			yield DesiredOp(self.checkWeather(), 80)
		for uid, unit in self.myUnits().iteritems():
			moveOp = self.move(unit)
			if moveOp is None:
				continue
			mapSize = distance(Pos(0,0), Pos(self.m.height, self.m.width))
			# further units from base are prioritized
			normDist = distance(Pos(0,0), unit.pos)/mapSize
			yield DesiredOp(moveOp, normDist * 100)
		for uid, up in self.myUnits().iteritems():
			if distance(up.pos, self.enemyBase().pos) <= 1:
				yield DesiredOp(self.attack(up.unit, self.enemyBase().unit), 100)

	# API wrappers
	def endTurn(self):
		self.state = self.client.endTurn(self.tok)
	def surrender(self):
		self.client.surrender(self.tok)
		self.log("I'm done")
	def log(self, m):
		self.client.log(m, self.tok)

import argparse
import sys

parser = argparse.ArgumentParser(add_help=False)
parser.add_argument("-i", "--interactive", help="wait between turns", action="store_true")
parser.add_argument("-h", "--host", default="localhost", help="host to connect to")
parser.add_argument("-p", "--port", default=9090, type=int, help="port to connect to")
parser.add_argument("-s", "--skill", default=1.0, type=float, help="skill level, [0,1]")
parser.add_argument("name", default="ai", help="identity to use on server")
parser.add_argument("--help", action="store_true")
args = parser.parse_args()

if args.help:
	parser.print_help()
	sys.exit(1)

ai = SimpleAI(args.host, args.port, args.name, args.skill)
while ai.state.itsOn:
	reqs = reversed(sorted([op for op in ai.requests()]))
	for req in reqs:
		if req.op is None:
			continue
		if args.interactive:
			print(req.op)
		success = ai.client.op(req.op, ai.tok)
		if not success:
			break
	# for watching the game
	if args.interactive:
		raw_input("> ")
	# DEBUG: simulate thinking time
	# time.sleep(0.5)
	ai.endTurn()
if ai.state.hasLost[ai.pid]:
	print("we lost :(")
else:
	print("we won!")
