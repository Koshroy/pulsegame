#!/usr/bin/env python

from __future__ import print_function, division

from thrift.transport import TTransport, TSocket
from thrift.protocol import TBinaryProtocol

# from gen_py.pulsearena.ttypes import Match
from gen_py.pulsearena import Arena

import re
import sys
import json
from os import path
import subprocess
import time
import random
import argparse

class Substitution:
	def __init__(self, s):
		self.s = s
	def needle(self):
		return "%" + self.s
	def __str__(self):
		return self.needle()
	def replace(self, args, env):
		for i,arg in enumerate(args):
			args[i] = re.sub(self.needle(), str(env[self.s]), arg)
		return args

parser = argparse.ArgumentParser(add_help=False)
parser.add_argument("-a", "--arena", default="default", \
	help="use named arena in config file")
parser.add_argument("-h", "--host", default=None, help="host to connect to")
parser.add_argument("-p", "--port", default=None, type=int, help="port to connect to")
parser.add_argument("-n", "--name", default=None, help="team name")
parser.add_argument("-f", "--forever", default=False, help="keep re-running", action="store_true")
parser.add_argument("--help", action="store_true")
try:
	sepIndex = sys.argv.index("--")
	argv, cmd_args = sys.argv[1:sepIndex], sys.argv[sepIndex+1:]
	args = parser.parse_args(argv)
# "--" not included, parse all known args
except ValueError:
	args, cmd_args = parser.parse_known_args()

if args.help:
	parser.print_usage()
	sys.exit(1)

# config is first filled with defaults
config = {
"host": "localhost",
"port": 8090,
"name": None,
}

# then config is filled with the json file, if possible
if path.isfile("arena.json"):
	f = open("arena.json", 'r')
	try:
		jsonConfig = json.load(f)
	except ValueError as e:
		print("syntax error in json file")
		print(e.message)
		f.close()
		sys.exit(1)
	f.close()
	if "name" in jsonConfig:
		config["name"] = jsonConfig["name"]
	if args.arena not in jsonConfig:
		print("could not find named 'arena' %s in config!" % args.arena)
		sys.exit(1)
	for key, val in jsonConfig[args.arena].iteritems():
		config[key] = val

# lastly fill from the args
for k, v in vars(args).iteritems():
	if v is not None:
		config[k] = v

# if after all that name is not set, bail out
if config["name"] is None:
	print("please identify yourself (-n/--name)")
	parser.print_usage()
	sys.exit(1)

print("config: %s" % str(config))
print("command line: %s" % str(cmd_args))

socket = TSocket.TSocket(config["host"], int(config["port"]))
transport = TTransport.TFramedTransport(socket)
protocol = TBinaryProtocol.TBinaryProtocol(transport)
client = Arena.Client(protocol)
transport.open()

substitutions = [
		Substitution("host"),
		Substitution("port"),
		]

cmd_args = Substitution("name").replace(cmd_args, {"name":config["name"]})

while True:
	match = client.getMatch(identity=config["name"])
	print("match found: %s" % str(match))
	env = {
			"host": match.host,
			"port": match.port,
			}
	match_cmd_args = [arg for arg in cmd_args]
	for sub in substitutions:
		match_cmd_args = sub.replace(match_cmd_args, env)
	# cmd_args now have magic variables specified in substitutions filled in
	subprocess.call(match_cmd_args)
	if not args.forever:
		break
	time.sleep(random.uniform(2,5))

transport.close()
