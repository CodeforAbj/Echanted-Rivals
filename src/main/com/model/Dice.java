package main.com.model;

public class Dice {
	private int lowestDigit;  // for making special dices like lucky
	private int highestDigit; // for making Different Dices
	private int face;
	
	public Dice() {
		this.lowestDigit = 1;
		this.highestDigit = 6;
		this.face = (int) (Math.floor((Math.random()*6)+1)); 
		// Assign random value between 1-6
	}
	
	// Getters
	public int getFace() {
		return this.face;
	}
	public int getLowerLimit() {
		// made for testing
		return this.lowestDigit;
	}
	
	public int getUpperLimit() {
		// made for testing
		return this.highestDigit;
	}
	
	// Methods
	public int roll() {
		this.face = (int) (Math.floor((Math.random()*6)+1)); 
		return face;
	}
}