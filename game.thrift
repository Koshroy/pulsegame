/**
	Very much a work-in-progress definition of the Pulse turn-based strategy game.
	Designed by: Tej Chajed, Koushik Roy
	Spring 2013

	notes:
	* Using only optional fields because its safer and until we figure out how we
	want to decide that.
	* These types are nested deep; recommend writing helper functions to access
		things you care about.
*/

namespace java edu.illinois.ece.pulsegame
namespace cpp pulsegame
namespace go pulsegame

/**
	IMPORTANT: this is a random number that you use as a cookie or nonce so that
	you cannot pretend to be the opponent
 */
typedef i64 Token

/**
	Types of units. Unit strengths and weaknesses are weather-dependent.
*/
enum UnitType {
	TYPE0 = 0,
	TYPE1 = 1,
	TYPE2 = 2,
	BASE = 3,
}

/**
	How position is mapped
*/
struct Pos {
	1: optional i32 y;
	2: optional i32 x;
}

/**
	Represents a live unit.

	There is at least one case where we might want to talk about a unit by
	itself without a position: when referring to an enemy to attack, we may not
	want to restrict ourselves to an attack on a unit in one position
*/
struct Unit {
	/**
		A unique id that lets us identify units.
	 */
	1: optional i64 id;
	2: optional UnitType type;
	3: optional i32 health;
}

/**
	A unit that is alive and positioned somewhere on the map.
*/
struct UnitPos {
	1: optional Unit unit;
	2: optional Pos pos;
}

/**
	Wraps together World State, state which is associated with the whole world
	and concerns both players.
*/
struct WorldState {
	/**
		A list of maps, where each map corresponds to one player's units.
		worldstate.units[pid] will get 	your own units and units[1-pid] will get your
		opponents.  The maps are from the unit id to the unit itself (including its
		position and health in the UnitPos struct).
	 */
	1: optional list< map<i64, UnitPos> > units;
	/**
		Similarly, the bases for both players. These are not present in the units maps.
	*/
	2: optional list<UnitPos> bases;
}

/**
Weather conditions.

Normal is where 0 beats 1, 1 beats 2 and 2 beats 0.

Reversed is the reverse of normal.

Dominate is where 0 beats both 1 and 2

Weak is where 0 is weak to both 1 and 2
*/
enum WeatherCond {
	NORMAL = 0,
	REVERSED = 1,
	DOMINATE = 2,
	WEAK = 3
}

/**
	Represents a view of the weather. The turn tells you how out of date it is.
	Weather conditions are guaranteed to stay constant for at least 3 turns.
*/
struct WeatherState {
	1: optional WeatherCond condition;
	// the turn where this condition became known
	2: optional i32 turn;
}

/**
	Captures user-specific state; this is stuff you see about yourself but not
	about the opponent. Includes redundant info about the last turn that might be
	useful; how many ops were valid and how many were invalid. Sum of these two
	is length of submitted queue and queueLen = maxQueueLen - 0.5 *
	lastInvalidOps.
*/
struct UserState {
	/**
		the queue length for this turn
	 */
	1: optional i32 queueLen;
	2: optional i32 lastValidOps;
	3: optional i32 lastInvalidOps;
	4: optional i32 gold;
	/**
		This is your view of the weather. Depending on what you do, it could be
		more or less up-to-date than your opponents.
	*/
	5: optional WeatherState weather;
}

/**
	A wrapper for all the state needed between turns. Both players receieve the
	same state, except for the user field, which has user-specific state.
*/
struct State {
	1: optional WorldState world;
	2: optional i32 turnNum;
	3: optional UserState user;
	/** Tells you who has lost so far. */
	4: optional list<bool> hasLost;
	/** If it's on, you should keep playing. */
	5: optional bool itsOn;
}

/**
	~The type of tiles~ 

	Plains -Readily traversable, pretty much "normal ground" 

	Hills  -Limits movement, Once you travel over a hill you cant move any further

	Oceans -Impassable, Similar to lava in the game "the floor is lava"
 */
enum TileType {
	PLAINS = 0,
	HILL = 1,
	OCEAN = 2
}

struct GameMap {
	1: optional list<list<TileType>> tiles;
	/**
		Units cannot stack at all, so use this array to avoid submitting move
		operations that fail since someone is already there.
	*/
	2: optional list<list<bool>> occupied;
	// These size parameters may be useless, depending on what list<> ends up
	// being in generated code.
	// TODO: check on this in C++, Java, Python
	/** the first dimension of tiles */
	3: optional i32 height;
	/** the second dimension of tiles */
	4: optional i32 width;
}

struct InitialGame {
	/** needed to authenticate all future operations */
	1: optional Token tok;
	2: optional State state;
	/** player id; will be 0 or 1 */
	3: optional i32 pid;
	/** the game map will only be given once in this struct */
	4: optional GameMap gameMap;
}

/**
	The four operations possible. Move, attack and buy are explained alongside
	their arguments (MoveOp, AttackOp and BuyOp). Check weather is a unique
	operation that consumes half the maximum queue length. It updates the
	WeatherState in your own UserState.
*/
enum OpType {
	MOVE,
	ATTACK,
	BUY,
	CHECK_WEATHER,
}

// ~Check weather~
// has no args and also takes multiple queue slots (half the maximum queue size)
// Failures:
// never fails, will not be added to the queue if there isn't enough room


// Use a type per op that holds its args (need to consider having "args" in the
// names of each of these types)
// All of these fields are required (would only change if parameters became
// optional, which is a bad idea for a service call)

/** ~Move unit to location~

 <Legal moves are based on terrain>

 Can move across up to 2 plains

 Can move to an adjacent hill

 Oceans are impassible

 All distances are Manhattan distance, abs(difference in x) + abs(difference in y)

 Failures:

 would fail if unit does not exist or if destination is occupied (by anybody,
 or a base)
*/
struct MoveOp {
	1: optional Unit unit;
	2: optional Pos destination;
}

/**
	~Attack a unit~

	Attacker inflicts damange to enemy based on their types

	Failures:

	If attacker or enemy is dead, or if enemy is now out-of-range (attack radius
	is 1)
*/
struct AttackOp {
	1: optional Unit attacker;
	2: optional Unit enemy;
}

/**
	~Buy a unit~

 Specify what type unit you want and where it should spawn 

 Can spawn within radius 2 of base

 <Failures>

 Pos is too far away 

 Don't have enough money
 */
struct BuyOp {
	1: optional UnitType type;
	2: optional Pos startPos;
}

/** Operations
	It's nice to have a unified, abstract "operation" that can be any operation
	because queueing works on operations generically, we need to have lists of
	operations, and clients may do sophisticated (or maybe necessary) things like
	their own queueing, prioritizing a bunch of operations, or things we didn't think of.

	However, it means we have to encode operations. The OpType specifies what
	this operation is; the other fields are the arguments. Only the set of
	arguments relevant to the type will be read.
 */
struct Op {
	1: optional OpType type; // this is really required; rest are optional
	2: optional MoveOp move;
	3: optional AttackOp attack;
	4: optional BuyOp buy;
}


service Game {
	/**
		Injects an arbitrary string into the log, under your username. Use for
		debugging -- please don't spam the server, it will only hurt you.
	 */
	void log(1: string logLine, 2: Token tok);

	/**
	Initialize the game using a given identity. Response includes everything
	needed to start playing; this call blocks until both players are in the game.
	 */
	InitialGame startGame(1: string identity);

	/**
	Enqueue an operation; returns true if the operation was queued (may fail if
	user has already filled their queue). This is a successful op as opposed to
	valid one, which can only be determined when the server is done processing
	earlier actions and will not be reported on a per-op basis (only in aggregate
	in UserState).
	 */
	bool op(1: Op operation, 2: Token tok);

	/**
		End the current turn. when both players have ended their turns, the server
		can process both players' queues. You have 1 second after ending your turn
		to finish your next turn and call endTurn again.
	 */
	State endTurn(1: Token tok);

	/**
		For development, useful to end game early rather than wait for timeout.
	*/
	void surrender(1: Token tok);
}
