#!/usr/bin/env python

from __future__ import print_function, division

from thrift.transport import TTransport, TSocket
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

from gen_py.game import Game

class GameHandler:
	def __init__(self):
		self.client = None
		self.host = None
		self.port = None

	def log(self, logline, tok):
		self.client.log(logline, tok)

	def startGame(self, identity):
		return self.client.startGame(identity)

	def endTurn(self, tok):
		return self.client.endTurn(tok)

	def op(self, op, tok):
		return self.client.op(op, tok)

	def surrender(self, tok):
		self.client.surrender(tok)
	
	# once remote is set, does not change
	def setRemote(self, host, port):
		# if the host has changed, then do this
		if host != self.host or port != self.port:
			self.host = host
			self.port = port
			socket = TSocket.TSocket(host, int(port))
			transport = TTransport.TFramedTransport(socket)
			protocol = TBinaryProtocol.TBinaryProtocol(transport)
			self.client = Game.Client(protocol)
			self._transport = transport
			transport.open()
	
handler = GameHandler()
processor = Game.Processor(handler)
transport = TSocket.TServerSocket(port=6090)
tfactory = TTransport.TFramedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print("Server running")
server.serve()
