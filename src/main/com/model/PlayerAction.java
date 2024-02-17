package main.com.model;

//Methods to be implemented according to player type

public interface PlayerAction {
	 
	void attack(Player opponent, Dice dice);  
	 	 
	void defend(int damage, Dice dice);

}
