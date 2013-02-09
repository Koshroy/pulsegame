#include "Client.h"

#include <limits.h>

Pos pos(int y, int x) {
	Pos p;
	p.y = y;
	p.x = x;
	return p;
}

Client::Client(string host, string port, string name) :
	host(host), port(port), name(name) {
	// Set up a client to the local proxy server; if this fails the proxy is not
	// running.
	boost::shared_ptr<TTransport> socket(new TSocket("localhost", 6090));
	boost::shared_ptr<TTransport> transport(new TFramedTransport(socket));
	boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
	client = new GameClient(protocol);
	transport->open();
	client->setRemote(host, port);
	client->startGame(game, name);
	state = game.state;
}

UnitType::type Client::bestType() {
	return UnitType::TYPE2;
}

Op Client::purchaseOrder() {
	Op op;
	op.type = OpType::BUY;
	BuyOp buy;
	buy.type = bestType();
	if (game.pid == 0) {
		buy.startPos = pos(6,6);
	} else {
		buy.startPos = pos(game.gameMap.width - 6, game.gameMap.height - 6);;
	}
	op.buy = buy;
	return op;
}

int sgn(int a) {
	if (a > 0) {
		return 1;
	} else if (a < 0) {
		return -1;
	}
	return 0;
}

// Probabilistically check the weather.
bool Client::maybeCheckWeather(float prob) {
	int r = random();
	if (r < (int) (INT_MAX * prob)) {
		Op op;
		op.type = OpType::CHECK_WEATHER;
		// This call will only fail if there isn't enough space in the queue; in this
		// case, there is no penalty, the action is simply ignored.
		return executeOp(op);
	}
	// return true since there wasn't a problem
	return true;
}

// Generate a list of movement operations for the army.
vector<Op> Client::moveArmy() {
	vector<Op> movements;

	// unit is a pair id, UnitPos, so for example unit->second.pos is its
	// position.
	map<int64_t, UnitPos> units = getUnits(pid());
	// Cannot iterate over a container of size 0.
	if (units.size() == 0) {
		return movements;
	}
	for (unit_it unit = units.begin(); unit != units.end(); unit++) {
		Pos dst(unit->second.pos);
		dst.x += sgn(enemyBase().pos.x - unit->second.pos.x);
		dst.y += sgn(enemyBase().pos.y - unit->second.pos.y);
		Op op;
		op.type = OpType::MOVE;
		MoveOp move;
		move.unit = unit->second.unit;
		move.destination = dst;
		op.move = move;
		movements.push_back(op);
	}

	return movements;
}

/**
 * Functions to fetch state.
 */

bool Client::itsOn() {
	return state.itsOn;
}

/**
 * Do not keep this iterator between turns! Such a design would be poor and
 * this iterator will be invalidated anyway.
 */

map<int64_t, UnitPos> Client::getUnits(int id) {
	return state.world.units[id];
}

UnitPos Client::myBase() {
	return state.world.bases[pid()];
}

UnitPos Client::enemyBase() {
	return state.world.bases[1-pid()];
}

int Client::pid() {
	return game.pid;
}

/**
 * API wrappers.
 */

// End the current turn.
void Client::endTurn() {
	printf("turn %d itsOn: %d\n", state.turnNum, state.itsOn);
	client->endTurn(state, game.tok);
	printf("turn %d itsOn: %d\n", state.turnNum, state.itsOn);
}

bool Client::executeOp(Op operation) {
	return client->op(operation, game.tok);
}

// Surrender the game. Useful for development.
void Client::surrender() {
	client->surrender(game.tok);
}
