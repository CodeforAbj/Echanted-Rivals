package tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import main.com.Main;
import main.com.model.Player;

public class MainTest {
/*
 * This will test register method for Main class
 */
	public static void main(String[] args) {
	/*
		 Required fields and data types
		 String playername, int healthPoints, int attackPoints, int strengthPoints
	*/		
		// Test for normal Values
		
		String normalInput = String.format("%s%n%d%n%d%n%d%n", "Tester",  100, 10, 20);
		System.out.println("Testing for Normal attributes");
		testMainRegister(normalInput);
		// Tests Negative Attributes
		// First Negative Values are provided then correct value to check what final object will have
		String nagativeInput = String.format("%s%n%d%n%d%n%d%n%d%n%d%n%d%n", "Tester", -100, 100, -10, 10, -20, 20);
		System.out.println("Testing for negatives attributes");
		testMainRegister(nagativeInput); 
		
		// Tests if Attributes with zero value accepted or not
		String zeroInput = String.format("%s%n%d%n%d%n%d%n%d%n%d%n%d%n", "Tester", 0, 100, 0, 10, 0, 20);
		System.out.println("Testing for zero value attributes");
		testMainRegister(zeroInput);
	}

	private static void testMainRegister(String input) {
		
		
		boolean flag = true; // To check if any test failed
		// Mocking Userinput 
		InputStream inputStream = new ByteArrayInputStream(input.getBytes()); 
		System.setIn(inputStream);   // Custom input stream
		Scanner s = new Scanner(inputStream);
		
		// Storing reference to Original Output Stream
		PrintStream originalOut = System.out; 
		
		 // To capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));     // the custom OutputStream to reduce the unneccessary output for test
        
		Player player = Main.register(s);
		
		 // Reset System.out to original output stream
	    System.setOut(originalOut);
		
		if(!player.getName().equals("Tester")) {
			System.out.println("Failed for matching name");
			flag=false;
		}
		if(player.getHealth()!=100)
		{
			System.out.println("Failed for matching Health");
			flag=false;
		}		
		if(player.getAttackPoints()!=10)
		{
			System.out.println("Failed for matching Attack Points");
			flag=false;
		}
		if(player.getStrengthPoints()!=20)
		{
			System.out.println("Failed for matching Strength Points");
			flag=false;
		}
		
		System.out.println(flag? "Test Passed":"Test Failed");
	}

}
