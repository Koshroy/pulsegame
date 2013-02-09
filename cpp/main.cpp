#include "Client.h"

#include <stdio.h>
#include <stdlib.h>

using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;

using namespace pulsegame;
using namespace std;

void usage() {
	cerr << "Usage: client <host> <port> <name>" << endl;
}

int main(int argc, char **argv) {
	if (argc < 4) {
		cerr << "not enough arguments" << endl;
		usage();
		return 1;
	}
	// These parameters are for the remote host
	string host(argv[1]);
	string port(argv[2]);
	string name(argv[3]);

	Client client(host, port, name);
	while (client.itsOn()) {
		Op op = client.purchaseOrder();
		// FIXME: check the return value! if it is false, your operation was not
		// queued. You should also be checking your queue size before blindly
		// submitting.
		client.executeOp(op);
		vector<Op> movements = client.moveArmy();
		for (op_it it = movements.begin(); it != movements.end(); it++) {
			client.executeOp(*it);
		}
		client.endTurn();
	}

  return 0;
}
