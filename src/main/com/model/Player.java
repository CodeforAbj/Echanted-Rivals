package main.com.model;

public class Player implements PlayerAction {
	private PlayerAttributes attributes;
	
	//Constructor
	public Player( String playername, int healthPoints, int attackPoints, int strengthPoints) {
			this.attributes =new PlayerAttributes( playername, healthPoints, attackPoints, strengthPoints);
	}
	
	// Method overriding from the PlayerAction interface
	@Override
	public void attack(Player opponent, Dice dice) {
		System.out.print("Dice Roll for attack... ");
		int attackRoll = dice.roll();
		System.out.println(attackRoll);
		int attackdamage = attackRoll*this.attributes.getAttackPoints();
		System.out.println(this.attributes.getPlayerName()+" attacked with " + attackdamage + "points" );
		opponent.defend(attackdamage, dice);
	}
	
	// Method overriding from the PlayerAction interface
	@Override
	public void defend(int damage, Dice dice) {
		System.out.print("Dice Roll for defence... ");
		int defenceRoll = dice.roll();
		System.out.println(defenceRoll); // Displaying what user rolled
		
		int defendableDamage = defenceRoll*this.attributes.getStrengthPoints(); // The ammount that can be shielded
		
		System.out.println(this.attributes.getPlayerName()+" defended " + defendableDamage + "points" ); // Updating the user of status and Process
		
		if(damage>defendableDamage) {
			// Case of player taking damage
			int health = this.attributes.getHealthPoints();
			int effectiveDamage = damage-defendableDamage;
			System.out.println("took " + effectiveDamage + " points of damage");
			this.attributes.setHealthPoints(health-effectiveDamage);
		}
		else {
			// Case of all damage defended
			System.out.println("No damage taken");
		}
		
	}
	
	// Getters
	public int getHealth() {
		return this.attributes.getHealthPoints();
	}
	public String getName() {
		return this.attributes.getPlayerName();
	}
	
	// Following two classes are used in Tests primariliy
	public int getAttackPoints() {
		return this.attributes.getAttackPoints();
	}
	public int getStrengthPoints() {
		return this.attributes.getStrengthPoints();
	}

		
}
