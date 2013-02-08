PulseCraft
=========
"The only choice is war. The only allies are enemies."
ECE Pulse 2013 Software Competitions Instructions
-------------------------------------------------

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


attack will trump enemy berserkers. Berserkers’ spears penetrate the 
armored soldiers. Soldier units can withstand arrow piercing and 
eliminate archers.

During a rainstorm, Artillery lose their accuracy to hit smaller Mech units
but can hit Tanks slowed down by mud, Tanks however now have an advantage over
Mech units who are exposed to the harsh rain enviroment. Mechs being harder to
target in the rain now can approch Artillery without being blown away from a distance.

When faced with a Heatwave, Mechs gain a dominance against both Tanks and Artillery
due to crewmembers baked alive in literal "hot boxes"

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

###Functionality
