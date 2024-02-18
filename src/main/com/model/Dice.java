package main.com.model;

public class Dice {
	private int lowestDigit;  // To create dice which can have any start and end value
	private int highestDigit; 
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