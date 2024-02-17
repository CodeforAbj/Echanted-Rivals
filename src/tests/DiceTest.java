package tests;

import main.com.model.Dice;

public class DiceTest {

	public static void main(String[] args) {
		
			testConstructor();
			testRolling();
	}

	
	private static void testConstructor() {
		System.out.println("Testing Constructor of Dice");
		int testcount = 1000; // Testing for 1000 for now
		boolean flag = false;
		while(testcount>0) {
			Dice testDice = new Dice();
			if(testDice.getFace()<=testDice.getLowerLimit() && testDice.getFace()>testDice.getUpperLimit()) {
				flag = true;
				break; // Breaks the loop if case is out of bounds
			}
			testcount--;
		}
		if(!flag) {
			System.out.println("Great Success : Default Value is within permissible range");
		}
		else {
			System.out.println("Failed: Default face Value is Out of its Bound");
		}
	}
	
	private static void testRolling() {
		System.out.println("Testing Rolling funtion of Dice");
		int testcount = 1000; // Testing for 1000 for now
		boolean flag = false;
		while(testcount>0) {
			Dice testDice = new Dice();
			if(testDice.roll()<=testDice.getLowerLimit() && testDice.roll()>testDice.getUpperLimit()) {
				flag = true;
				break; // Breaks the loop if case is out of bounds
			}
			testcount--;
		}
		if(!flag) {
			System.out.println("Great Success : Rolled Value is within permissible range");
		}
		else {
			System.out.println("Failed: Rolled Value is Out of its Bound");
		}
	}


}
