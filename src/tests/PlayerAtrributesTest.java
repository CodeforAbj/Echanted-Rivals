package tests;

import main.com.model.PlayerAttributes;

public class PlayerAtrributesTest {

	public static void main(String[] args) {
		testGetters();
        testSetters();
		
	}
	private static void testGetters() {
		System.out.println("Testing Getters for PlayerAttributes");
		
		PlayerAttributes playerAttributes = new PlayerAttributes("TestPlayer", 100, 10, 20);
		boolean flag = true; // For checking finaaly after all getters
        // Testing getters for each property
        if (!playerAttributes.getPlayerName().equals("TestPlayer")) {
            System.out.println("Failed: In mathcing Playername");
            flag= false;
        }
        if (playerAttributes.getHealthPoints() != 100) {
            System.out.println("Failed: In mathcing Playername");
            flag= false;
        }
        if (playerAttributes.getAttackPoints() != 10) {
            System.out.println("Failed: In mathcing Attack Points");
            flag= false;
        }
        if (playerAttributes.getStrengthPoints() != 20) {
            System.out.println("Failed: In matching Strength Points");
            flag= false;
        }

        if(flag)
        System.out.println("Getters test passed for Class Player Attributes");
		return;
	}
	
	private static void testSetters() {
		System.out.println("Testing Setters for PlayerAttributes");
		
		PlayerAttributes playerAttributes = new PlayerAttributes("TestPlayer", 100, 10, 20);

		boolean flag = true; // For checking finaaly after all setters
		
        // Test setters
        playerAttributes.setPlayername("TestSetter");
        if (!playerAttributes.getPlayerName().equals("TestSetter")) {
            System.out.println("Failed: In matching Updated Name");
            flag=false;
        }

        playerAttributes.setHealthPoints(150);
        if (playerAttributes.getHealthPoints() != 150) {
            System.out.println("Failed:  In matching Updated Health");
            flag=false;
        }

        playerAttributes.setAttackPoints(15);
        if (playerAttributes.getAttackPoints() != 15) {
            System.out.println("Failed:  In matching Updated AttackPoints");
            flag=false;
        }

        playerAttributes.setStrengthPoints(25);
        if (playerAttributes.getStrengthPoints() != 25) {
            System.out.println("Failed: In matching Updated AttackPoints");
            flag=false;
        }

        if(flag)
        System.out.println("Setters test passed for Class Player Attributes");
		return;
	}

	

}
