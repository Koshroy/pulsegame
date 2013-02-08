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
In the middle of the war. Searching for an end.

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
The game type and style is that of a real-time strategy game (RTS)
visualized in a top-down view. The performance of your AI should be 
universal in a variety of contexts. 

###Units
You are allowed to create and 
organize armies containing 3 types of units.

*Mechs: Infantry units specializing in the destruction of armored vehicles
*Tanks: Its a fucking tank
*Artillery: Long range bombardment units

Arena maps may be randomly generated during post-testing 
and may vary in geography and base locations and distances. 

###Weather
Additionally, the weather, or map status, will alter the effectiveness 
of certain units. 

Under normal weather conditions the Artillery shreds the unarmored Mechs, Tanks 
dominate slow moving Artillery, and Mechs can outmanuver short ranged Tanks.

During a rainstorm, Artillery lose their accuracy to hit smaller Mech units
but can hit Tanks slowed down by mud, Tanks however now have an advantage over
Mech units who are exposed to the harsh rain enviroment. Mechs being harder to
target in the rain now can approch Artillery without being blown away from a distance.

When faced with a Heatwave, Mechs gain a dominance against both Tanks and Artillery
due to crewmembers being baked alive in literal "hot boxes".

When a Coldwave hits, Tanks and Artillery gain dominance against Mechs who are exposed 
to the harsh winter enviroment.

To sum up the weather phenomena and their effects on units, refer to the following list

NORMAL:   Mechs > Tanks > Artillery > Mechs

RAINSTORM:   Tanks > Mechs > Artillery > Tanks

HEATWAVE:   Mech > Tanks = Artillery

COLDWAVE:  Tanks = Artillery > Mechs

All players accumulate gold without maintained acquisition. 
The rate of accumulation is set constant and gold compounds 
per turn. During post-testing, this rate of gold per turn 
may be altered to judge AI flexibility.

Functionality
-------------
###Thrift
_Is there anything I should do_

Read the documentation

_What is Thrift?_

When we say thrift we are talking about Apache Thrift. The following defenition is taken from the Thrift Website.
>The Apache Thrift software framework, for scalable cross-language services development, combines a
software stack with a code generation engine to build services that work efficiently and seamlessly between
C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, OCaml, Delphi and other languages

_Why did Pulse choose Thrift?_

Its cross platform.

