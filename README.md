
# Enchanted Rivals

This Java project simulates a Dueling Arena Board Game where Two players engage in one on one battle in which they attack turn wise until one player dies. Each player is characterized by their name, health, strength, and attack attributes.


## Table of Contents


  - [Game Mechanics](#game-mechanics)
  - [Run Locally](#run-locally)
  - [Example](#example)
  - [Class Responsibilities](#class-responsibilities)
    - [Main Class](#main-class)
    - [Arena Class](#arena-class)
    - [PlayerAttributes Class](#playerattributes-class)
    - [PlayerAction Interface](#playeraction-interface)
    - [Player Class](#player-class)
    - [Dice Class](#dice-class)
  - [Tests](#tests)
    - [MainTest Class](#maintest-class)
    - [ArenaTest Class](#arenatest-class)
    - [PlayerTest Class](#playertest-class)
    - [PlayerAttributesTest Class](#playerattributestest-class)
    - [DiceTest Class](#dicetest-class)
  - [Safety Features](#safety-features)
## Game Mechanics
- Players take turns attacking and defending.
- Player with lower health starts the first attack
- Attack damage is calculated by multiplying the attacker's attack points attribute with the outcome of the six faced dice roll.
- Defense strength is calculated by multiplying the defender's strength attribute with the outcome of the dice roll.
- Effective Damage inflicted on the defender is the amount of  attack damage minus defense strength.
- If Defence Value is higher than attack value then no damage is taken 
- The game ends when one player's health reaches zero
## Run Locally


Go to the project directory

```bash
  cd "Enchanted Rivals\output"
```

Run the jar file in cmd

```bash
 java -jar "Enchanted Rivals.jar"
```


## Example
```
PS E:\Programming stuff\Projects\Enchanted Rivals\output> java -jar 'Enchanted Rivals.jar'
```
```
[---------- Welcome to Enchanted Rivals ----------]
[---------- Register Player One ----------]
Enter the Name of Player
Tony
Enter Health Points of Tony
100
Enter Attack Points of Tony
20
Enter Strength points of Tony
10
[---------- Register Player Two ----------]
Enter the Name of Player
Eziekel
Enter Health Points of Eziekel
80
Enter Attack Points of Eziekel
30
Enter Strength points of Eziekel
20
Dice Roll for attack... 1
Eziekel attacked with 30points
Dice Roll for defence... 3
Tony defended 30points
No damage taken
Tony's healthPoints = 100
*****
Dice Roll for attack... 3
Tony attacked with 60points
Dice Roll for defence... 4
Eziekel defended 80points
No damage taken
Eziekel's healthPoints = 80
*****
Dice Roll for attack... 3
Eziekel attacked with 90points
Dice Roll for defence... 5
Tony defended 50points
took 40 points of damage
Tony's healthPoints = 60
*****
Dice Roll for attack... 6
Tony attacked with 120points
Dice Roll for defence... 1
Eziekel defended 20points
took 100 points of damage
[--------------------]
Tony Wins !
[--------------------]
[---------- Thank You for Playing !! ----------]
[---------- Project by @codeforabj !! ----------]

```
## Class Responsibilities
#### Main Class
- To Register Players with thier name, health, attack points and strength attributes taken from users
- To start the game in arena
#### Arena Class
- Running the game by startMatch method having player attack and defend by turn by turn 
- Declare the winner based which player loses full health first
- Deciding who attacks first i.e., whoever have lesser health and in case of equal health player two

#### PlayerAttributes Class
- Defining the properties of a player
- Having getters and setters for those properties

#### PlayerAction Interface
- Providing the blueprint of actions available for a player
#### Player Class
- Implementing the playerAction interface 
- Defining the mechanism of attack and defence

#### Dice Class
-  To create dice which can have any start and end value. 
- By default its 6 faced Dice
- To provide randomly generated number with range of dice

## Tests 
#### MainTest Class
- Tests the Regitration Method
    - Tests for normal expected values provided for atrributes
    - Test for negative values provided for atrributes
    - Test for zero values provided for atrributes
    - Test for wrong data type values provided for atrributes

#### ArenaTest Class
- Tests for expected outputs when randomness is fixed
    - Dice roll is overrided to fixed Value to control the outputs
    - Created the a Strong Player and a Weak Player to have a fixed output
    - Run the test for n number of times to ensure StrongPlayer wins

#### PlayerTest Class
- Tests for 1000 random values for attack and defend methods
    - Tests attack method with random values generated in loop for provided test count.
    - Tests defend method with random values generated in loop for provided test count.

#### PlayerAttributesTest Class
- Tests getter and setters for this Class

#### DiceTest Class
- Tests Dice Roll method for n test cases
    - Checks if return value is within range of dice
    
## Safety Features
- Added type safety for user inputs, it asks in a loop untill right type of values are provided 
-  User can't provide negative values for his attributes 
- User can't provide empty name 
- Attack Points and Strength Points cannot be set negative 
