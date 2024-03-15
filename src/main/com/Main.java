package main.com;

import java.util.Scanner;

import main.com.model.Dice;
import main.com.model.Player;
import main.com.service.Arena;

public class Main {

	public static void main(String[] args) {
		System.out.println("[---------- Welcome to Enchanted Rivals ----------]");
		
		Scanner s = new Scanner(System.in);
		// Player One Regstration
		System.out.println("[---------- Register Player One ----------]");
		Player playerOne = register(s);
		
		// Player Two registration
		System.out.println("[---------- Register Player Two ----------]");
		Player playerTwo = register(s);
		
		Dice D6 = new Dice(); // Dice of size 6
		
		Arena newArena = new Arena(playerOne,playerTwo,D6);
		newArena.startMatch();
		System.out.println("[---------- Thank You for Playing !! ----------]");
		System.out.println("[---------- Project by @codeforabj !! ----------]");
		s.close();
	}
	

	public static Player register(Scanner s) {
	    System.out.println("Enter the Name of Player");
	    String playerName = s.nextLine();

	    // For ensuring that name is not empty
	    while (playerName.isEmpty()) {
	        System.out.println("Nothing Entered. Please enter the name of the player:");
	        playerName = s.nextLine();
	    }

	    System.out.println("Enter Health Points of " + playerName );

	    // Safety for wrong input type
	    while (!s.hasNextInt()) {
	        System.out.println("Invalid input. Please enter an integer.");
	        s.next(); // To ignore the invalid input
	    }

	    int playerHealth = s.nextInt();
	    s.nextLine(); // Consume newline character

	    // For ensuring the input for health is positive always
	    while(playerHealth<=0) {
	        System.out.println("Health can't be less than or equal to zero. Enter again ");
	        playerHealth = s.nextInt();
	        s.nextLine(); // Consume newline character
	    }

	    System.out.println("Enter Attack Points of " + playerName );

	    // Safety for wrong input type
	    while (!s.hasNextInt()) {
	        System.out.println("Invalid input. Please enter an integer.");
	        s.next(); // To ignore the invalid input
	    }

	    int playerAttack = s.nextInt();
	    s.nextLine(); // Consume newline character

	    // For ensuring the input for attack points is positive always
	    while(playerAttack<=0) {
	        System.out.println("Attack points can't be less than or equal to zero. Enter again ");
	        playerAttack = s.nextInt();
	        s.nextLine(); // Consume newline character
	    }

	    System.out.println("Enter Strength points of " + playerName );

	    // Safety for wrong input type
	    while (!s.hasNextInt()) {
	        System.out.println("Invalid input. Please enter an integer.");
	        s.next(); // To ignore the invalid input
	    }

	    int playerStrength = s.nextInt();
	    s.nextLine(); // Consume newline character

	    // For ensuring the input for strength points is positive always
	    while(playerStrength<=0) {
	        System.out.println("Strength points can't be less than or equal to zero. Enter again ");
	        playerStrength = s.nextInt();
	        s.nextLine(); // Consume newline character
	    }

	    Player player = new Player(playerName, playerHealth, playerAttack, playerStrength);
	    return player;
	}
}
