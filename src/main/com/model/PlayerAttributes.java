/**
 * 
 */
package main.com.model;

/**
 * This Class will have statistics of player's profile
 */
public class PlayerAttributes {
	private String playername;
	private int healthPoints;
	private int attackPoints;
	private int strengthPoints;
	
	//constructor
	public PlayerAttributes(String playername,int healthPoints, int attackPoints, int strengthPoints ) {
		this.playername=playername;
		this.healthPoints=healthPoints;
		this.attackPoints=attackPoints;
		this.strengthPoints=strengthPoints;
		
	}
	
	//getters
	public String getPlayerName() {
		return this.playername;
	}
	public int getHealthPoints() {
		return this.healthPoints;
	}
	public int getAttackPoints() {
		return this.attackPoints;
	}
	public int getStrengthPoints() {
		return this.strengthPoints;
	}
	
	
	
	//setters with prevention for value bounds
	public void setPlayername(String playername) {
		this.playername=playername;
	}
	
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
		
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
	
	
}
