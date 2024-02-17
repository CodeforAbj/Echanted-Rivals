package tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import main.com.model.Dice;
import main.com.model.Player;

public class PlayerTest {

	public static void main(String[] args) {
			testAttack(1000);
			testDefend(1000);
	}
	
	private static void testAttack(int testCount) {
		
		// For checking if any test failed 
		
		boolean flag = true;
		
		while(testCount>0) {
		int randomHealth = generateRandomPositiveInteger(100); // MaxHealth for practical testing purpose
		int randomNumber = generateRandomPositiveInteger(30);  // Max Attack/Strength Points for testing purpose
		
		Player attacker = new Player("Attacker", randomHealth, randomNumber*2, randomNumber); 
		//Attacker Damage Doubled to ensure Defender Can't Defend 100% of damage
        Player defender = new Player("Defender", randomHealth, randomNumber, randomNumber);
        Dice dice = new Dice() {
            @Override
            public int roll() {
                // Custom roll method to ensure predictable results for testing
            	
                return 3; // Arbitrary fixed roll value for testing
            }
        };
        
     // Storing reference to Original Output Stream
     	PrintStream originalOut = System.out; 
     		
     		 // To capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));     // the custom OutputStream to reduce the unneccessary output for test
        
        
        attacker.attack(defender, dice);
        // Reset System.out to original output stream
	    System.setOut(originalOut);
        
	    int expectedAttackDamage = 3*randomNumber*2; // Here 3 is fixed Dice Roll and Damage Doubled  to ensure Defender Can't Defend 100% of damage
	    int expectedDefendedDamage = 3*randomNumber;
	    int expectedEffectiveDamage = expectedAttackDamage-expectedDefendedDamage; // Since Attack is always higher than Defence
	    int expectedHealth = randomHealth-expectedEffectiveDamage;
	    
	    if(defender.getHealth()!=expectedHealth)
	    {flag = false;}
	    	
        testCount--;
		}
		if(flag){
        	System.out.println("Test on Attack Method Passed : Expected Damage = Damage by attack method on all cases");
        }
        else {
        	System.out.println("Test on Attack Method Failed: Expected Damage != Damage by attack method on all cases");
        }
     }


	private static void testDefend(int testCount) {
		
		boolean flag = true;
		while(testCount>0) {
			int randomHealth = generateRandomPositiveInteger(100); // MaxHealth for practical testing purpose
			int randomNumber = generateRandomPositiveInteger(20);  // Max Attack/Strength Points for testing purpose
			
			Player defender = new Player("Defender", randomHealth, randomNumber, randomNumber);
	        Dice dice = new Dice() {
	            @Override
	            public int roll() {
	                // Custom roll method to ensure predictable results for testing
	            	
	                return 5; // Arbitrary fixed roll value for testing
	            }
	        };
	        
	     // Storing reference to Original Output Stream
	     	PrintStream originalOut = System.out; 
	     		
	     		 // To capture output
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));     // the custom OutputStream to reduce the unneccessary output for test
	        
	        
	        int expectedAttackDamage = 5*randomNumber*2; // Here 4 is fixed Dice Roll and Damage Doubled  to ensure Defender Can't Defend 100% of damage
	        defender.defend(expectedAttackDamage, dice);
	        // Reset System.out to original output stream
		    System.setOut(originalOut);
	        
		    int expectedDefendedDamage = 5*randomNumber;
		    int expectedEffectiveDamage = expectedAttackDamage-expectedDefendedDamage; 
		    int expectedHealth = randomHealth-expectedEffectiveDamage; // Since Attack damage is always higher than Defence Strength
		   
		    
		    
		    if(defender.getHealth()!=expectedHealth)
		    {flag = false;}
		    	
			testCount--;
		}
		if(flag){
        	System.out.println("Test on Defend Method Passed : Expected Health = Health After Damage by defend method on all cases");
        }
        else {
        	System.out.println("Test on Defend Method Failed: Expected Health != Health After Damage by defend method on all cases");
        }
		
	}


		// Function to randomise inputs
	    public static int generateRandomPositiveInteger(int upperlimit) {
	        Random random = new Random();
	        return random.nextInt(upperlimit) + 1; // limit to double it to ensure damage;
	    }
}
