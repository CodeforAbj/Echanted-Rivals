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
	private int strengthPoints;
	private String playername;
	//constructor
	public PlayerAttributes(int healthPoints, int attackPoints, int strengthPoints, String playername) {
		this.healthPoints=healthPoints;
		this.attackPoints=attackPoints;
		this.strengthPoints=strengthPoints;
		this.playername=playername;
	}
	
	//getters
	public int getHealthPoints() {
		return this.healthPoints;
	}
	public int getAttackPoints() {
		return this.attackPoints;
	}
	public int getStrengthPoints() {
		return this.strengthPoints;
	}
	public String getPlayerName() {
		return this.playername;
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

	public void setStrengthPoints(int strengthPoints) {
	    if(strengthPoints>=0)
		this.strengthPoints = strengthPoints;
		else
		System.out.println("Strength Points Can't be negative value");
	}
	
	public void setPlayername(String playername) {
		this.playername=playername;
	}
}
