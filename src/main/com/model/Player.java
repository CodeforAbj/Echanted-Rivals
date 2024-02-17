package main.com.model;

public class Player implements PlayerAction {
	private PlayerAttributes attributes;
	
	public Player(int healthPoints, int attackPoints, int strengthPoints, String playername) {
			this.attributes =new PlayerAttributes(healthPoints, attackPoints, strengthPoints, playername);
	}
	@Override
	public void attack(Player opponent, Dice dice) {
		System.out.print("Dice Roll for attack... ");
		int attackRoll = dice.roll();
		System.out.println(attackRoll);
		int attackdamage = attackRoll*this.attributes.getAttackPoints();
		System.out.println(this.attributes.getPlayerName()+" attacked with " + attackdamage + "points" );
		opponent.defend(attackdamage, dice);
	}

	@Override
	public void defend(int damage, Dice dice) {
		System.out.print("Dice Roll for defence... ");
		int defenceRoll = dice.roll();
		System.out.println(defenceRoll);
		int defendableDamage = defenceRoll*this.attributes.getStrengthPoints();
		System.out.println(this.attributes.getPlayerName()+" defended " + defendableDamage + "points" );
		if(damage>defendableDamage) {
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
	

}
