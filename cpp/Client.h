#ifndef CLIENT_H
#define CLIENT_H

#include "Game.h"

#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <transport/TSocket.h>
#include <transport/TBufferTransports.h>
#include <protocol/TBinaryProtocol.h>

using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace std;
using namespace pulsegame;

// These save a lot of typing and make code more readable.
typedef vector<Op>::const_iterator const_op_it;
typedef vector<Op>::iterator op_it;

typedef map<int64_t, UnitPos>::iterator unit_it;

class Client {
	public:
		Client(string host, string port, string name);

		UnitPos myBase();
		UnitPos enemyBase();
		int pid();

		UnitType::type bestType();
		Op purchaseOrder();
		bool maybeCheckWeather(float prob);
		vector<Op> moveArmy();

		bool itsOn();

		void endTurn();
		void surrender();
		bool executeOp(Op op);

	private:
		string host;
		string port;
		string name;

		GameClient *client;
		InitialGame game;
		State state;

		/**
		 * Helper function to get the vector of a particular id's units.
		 */
		map<int64_t, UnitPos> getUnits(int id);
};

#endif
