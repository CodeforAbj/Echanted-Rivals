package tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import main.com.model.Dice;
import main.com.model.Player;
import main.com.service.Arena;

public class ArenaTest {

	public static void main(String[] args) {
		testStartMatch(20);

	}

	private static void testStartMatch(int testCount) {
		System.out.println("Tesing Arena GamePlay");
		boolean flag = true;
		String failedGameLog = "Inital Value"; // For storing if it fails for any random values
		// just to mark failures
		while(testCount>0) {
			int randomHealth = generateRandomPositiveInteger(100); // MaxHealth for practical testing purpose
			int randomNumber = generateRandomPositiveInteger(30);  // Max Attack/Strength Points for testing purpose
			
			
			Player StrongPlayer = new Player("StrongPlayer", randomHealth, randomNumber, randomNumber); 
			//OnePlayer is Stronger Attributes to ensure result to verify for tests 
	        Player WeakPlayer = new Player("WeakPLayer", randomHealth/2, randomNumber/2, randomNumber/2);
	        Dice dice = new Dice() {
	            @Override
	            public int roll() {
	                // Custom roll method to ensure predictable results for testing
	            	
	                return 6; // Arbitrary fixed roll value for testing
	            }
	        };
	        
	        // Storing reference to Original Output Stream
	     	PrintStream originalOut = System.out; 
	     		
	     	 // To capture output
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));     // the custom OutputStream to reduce the unneccessary output for test
	        
	        
	        Arena TestArena = new Arena(StrongPlayer, WeakPlayer, dice);
	        TestArena.startMatch();
	        String TestLog = outputStream.toString(); // converting the gamplay outputs in String to verify
	       
	        if (!TestLog.contains("StrongPlayer Wins !")) {
	        	flag=false;
	        	failedGameLog=TestLog;
	        }
	        
	        // Reset System.out to original output stream
		    System.setOut(originalOut);
		   
		    testCount--;
		    
		    
		}
		if(flag) {
			System.out.println("Great Success : Arena is working as Intended");
		}
		else {
			System.out.println("Failed: Failed Game Log as follows ");
			System.out.println(failedGameLog);
			}
	}
	// Function to randomise inputs
    public static int generateRandomPositiveInteger(int upperlimit) {
        Random random = new Random();
        return random.nextInt(upperlimit) + 1; // limit to double it to ensure damage;
    }


}
