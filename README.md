PulseCraft
=========
"The only choice is war. The only allies are enemies."
###ECE Pulse 2013 Software Competitions Instructions

Background
----------
The year is 2142

War has ravaged the land. The landscape torn up to a husk of its former self. 
We didnt know the war between Google and Bing would turn out this way but I guess
life is full of suprises. Ever since Bing realized they wouldn't beat Google in the 
western hemisphere Bing decided to market to the East. We all knew that Google
would take over the world but Bing was another story. Now here we are. 
In the middle of the war. The world has been scorched. Weather changes at random.
The Earth's people are searching for a stop to the fighting. Searching for an end.

In the field of war and destruction, you, an untried untested commander, has been
given the privilege of destruction. In a world of capricious slaughter and 
meaningless violence, you decide to make a difference. Google/Bing has given you
a chance and you will not disappoint. The world *will* know peace at your hand.

Objective
---------
Competition teams are tasked at battling one another in the
PulseCraft arena. The goal is to setup a functional and 
competent artificial intelligence script which can create 
and command an army to destroy the enemy base. Your script 
strategy should ideally utilize the full potential of the 
given client functions and be adaptable. 

Gameplay
--------
The game type and style is that of a turn-based strategy game
visualized in a top-down view. The goal of each AI player is to
destroy the other player's base. The first player's base is located
in the top-left corner of the map, 5 squares from the top, 5 squares
from the left. The second player's base is located in the bottom-right
corner of the map, 5 squares from the bottom, and 5 squares from the
right.

There is *no* fog of war. All units are visible at all times. All
bases are available at all times. The health of each unit and each
base is available at all times.

###Maps

Maps are 2D arrays of tiles. Map tiles can be either Ocean tiles, 
Mountain tiles, or Plains Tiles. Map files are specified in a simple
ASCII format and will be included in the code distribution.

###Units
You are allowed to create and organize armies containing 3 types of units.

* Mechs (Unit Type 0): Infantry, Specialized in the destruction of vehicles
* Tanks (Unit Type 1): Mechanized, Armored units with short range bombardment.
* Artillery (Unit Type 2): Mechanized, Ranged bombardment unit.

Units can move either across two plains squares or a single mountain square
per-turn. Units *cannot* move across an ocean square. All units cost the same 
amount to purchase per turn. There is *no* concept of range in the game. 
Units can only attack units that are located in adjacent squares.

###Operations
AI players can perform four "operations" or actions in the game. The operations
are as follows: MoveUnit, Attack, Buy, and CheckWeather.

* MoveUnit: Allows an AI player to move a unit to a target square on the map.
* Attack: Allows an AI player to specify a unit to attack an adjacent unit.
* Buy: Allows an AI player to purchase more units.
* CheckWeather: Allows the AI to query for the current state of the weather. This is 
  explained in detail in the Weather section.

Invalid operations are penalized. More information on invalid operations
is explained in the Operation Queues section.

###Operation Queues
Each player is given a queue of operations that they can issue operations to.
Each player can only issue as many queue operations as the length of his or her
queue allows. 

If a player issues an *invalid operation*, such as a Move to a location not
on the map or occupied by a unit, the Operation will fail and half of a queue
slot will be lost on the next turn. This discourages extremely aggressive clients.
Every operation except for CheckWeather occupies a single queue slot.
CheckWeather takes up half of an AI player's queue.

###Weather
Central to the concept of attacking in this game is the concept of Weather.
Weather affects the ability of a unit to damage another unit.
Under normal weather conditions the Artillery shreds the unarmored Mechs, Tanks 
dominate slow moving Artillery, and Mechs can outmanuver short ranged Tanks.

Diving weather is expensive. Due to the heavily altered state of the landscape
in this time of total war, highly skilled meteorologists must be employed to
obtain the status of the capricious weather. Player AIs must be conservative
in their desire to check the state of the current weather.

During a rainstorm, Artillery lose their accuracy to hit smaller Mech units
but can hit Tanks slowed down by mud, Tanks however now have an advantage over
Mech units who are exposed to the harsh rain enviroment. Mechs being harder to
target in the rain now can approch Artillery without being blown away from a distance.

When faced with a Heatwave, Mechs gain a dominance against both Tanks and Artillery
due to crewmembers being baked alive in literal "hot boxes".

When a Coldwave hits, Tanks and Artillery gain dominance against Mechs who are exposed 
to the harsh winter enviroment.

To sum up the weather phenomena and their effects on units, refer to the following list

* Normal (Weather Type 0):   Mechs > Tanks > Artillery > Mechs
* Rainstorm (Weather Type 1):   Tanks > Mechs > Artillery > Tanks
* Heatwave (Weather Type 2):   Mech > Tanks = Artillery
* Coldwave (Weather Type 3):  Tanks = Artillery > Mechs

The organizers of the competition will not, at any time reveal the nature of weather
generation. The only way for a player AI to query the status of the weather is to
issue a CheckWeather operation. The CheckWeather operation occupies half of the
player AI's queue. 

###Buying Units

Each AI player receives a fixed amount of gold per-turn. The AI player can choose when
and how to spend the money it receives per-turn. Gold can be used to purchase units.

###The Arena

In order to facilitate player testing, the organizers will be hosting a set of Arena
servers. Each Arena server allows individual player AIs to play against each other.
The Arenas are capable of keeping stats of each individual team.

It is *highly suggested* to enter the Arena as soon as possible. Entering the Arena
will give the player a much-needed look into the logic of the other players. Different
Arenas will be configured to serve different maps or different weather patterns.

###Local Testing

To further facilitate player testing, each player will be allowed to locally run a copy
of the server. The server code we distribute will not keep track of stats and will come
with a configuration file that exposes tweakable settings such as weather patterns.


Functionality
-------------
###Thrift
_What should I do next?_

Read the Thrift protocol definition. The protocol definition can be found in
game.thrift. The game designes heavily suggest reading the game.thrift file
for detailed design considerations.

_What is Thrift?_

Thrift refers to Apache Thrift, a cross platform abstract language which allows us to specify
and deploy a language agnostic description of the communication protocol. The following defenition
is taken from the Thrift Website.

>The Apache Thrift software framework, for scalable cross-language services development, combines a
software stack with a code generation engine to build services that work efficiently and seamlessly between
C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, OCaml, Delphi and other languages

_Why did Pulse choose Thrift?_

Thrift is language agnostic. It eases the burden on us for supporting multiple clients in different languages.
Thrift also allows programmers comfortable in languages we do not support to interface with our protocol
description.

_I wish to develop in a language that is not officially supported. What should I do?_

Read the Apache Thrift tutorial and try to implement the services we define in game.thrift. If you
are having trouble connecting to our server with your Thrift distribution, consider interfacing with
our wrapper script.

