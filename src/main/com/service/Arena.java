package main.com.service;

import main.com.model.Dice;
import main.com.model.Player;
/*
 * This class handles Games running logic
 * */
public class Arena {
	private Player playerOne;
	private Player playerTwo;
	private Dice dice;
	
	//Constructor
	public Arena(Player playerA, Player playerB, Dice dice) {
		// To ensure player with less health attacks first
		// as playerOne goes first to attack
		if(playerA.getHealth()<playerB.getHealth()) { 
			this.playerOne=playerA;
			this.playerTwo=playerB;	
		}
		else {
			this.playerOne=playerB;
			this.playerTwo=playerA;
		}
		
		this.dice=dice;
	}
	
	public void startMatch() {
		while(playerOne.getHealth()>0 && playerTwo.getHealth()>0) {
			
			// Attack of Player One
			
			playerOne.attack(playerTwo, dice);
			if(playerTwo.getHealth()<=0) {
				System.out.println(playerOne.getName()+" Wins !");
				break;
			}
			else {
				System.out.println(playerTwo.getName()+"'s healthPoints = "+playerTwo.getHealth());
			}
			
			// Attack of Player Two
			
			playerTwo.attack(playerOne, dice);
			if(playerOne.getHealth()<=0) {
				System.out.println(playerTwo.getName()+" Wins !");
				break;
			}
			else {
				System.out.println(playerOne.getName()+"'s healthPoints = "+playerOne.getHealth());
			}
		}
	}
}
