/**
 * 
 */
package main.com.model;

/**
 * This Class will have statistics of player's profile
 */
public class PlayerAttributes {
	private int healthPoints;
	private int attackPoints;
	private int defencePoints;
	//constructor
	public PlayerAttributes(int healthPoints, int attackPoints, int defencePoints) {
		this.healthPoints=healthPoints;
		this.attackPoints=attackPoints;
		this.defencePoints=defencePoints;
	}
	
	//getters
	public int getHealthPoints() {
		return this.healthPoints;
	}
	public int getAttackPoints() {
		return this.attackPoints;
	}
	public int getDefencePoints() {
		return this.defencePoints;
	}
	
	//setters with prevention for value bounds
	public void setHealthPoints(int healthPoints) {
		if(healthPoints>=0)
	    this.healthPoints = healthPoints;
		else
		System.out.println("Health Can't be negative value");
	}

	public void setAttackPoints(int attackPoints) {
		if(attackPoints>=0)
		this.attackPoints = attackPoints;
		else
		System.out.println("Attack Points Can't be negative value");
	}

	public void setDefencePoints(int defencePoints) {
	    if(defencePoints>=0)
		this.defencePoints = defencePoints;
		else
		System.out.println("Defence Points Can't be negative value");
	}

}
