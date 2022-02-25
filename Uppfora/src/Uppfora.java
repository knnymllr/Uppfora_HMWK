 /* Kenny Miller
 * CIS 1068 - Spring 2022
 * 
 * This is code for playing Uppfora against the computer
 * 1) Print rules to screen
 * 2) Ask user, would you like to play?
 * 3) If yes, pick one of five moves
 * 4) Generate random computer move
 * 5) Print user and computer moves
 * 6) Ask play again
 * 7) If no, print: # of rounds # user wins # computer wins
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class Uppfora {
	public static void main(String[] args) {
		// Initialize game
		initGame();
		
	/*
	 * END OF MAIN
	 */
	}
	
	// Print rules to screen
	public static void rules() {
		System.out.println("UPPFORA\n\nRULES\n");
		System.out.println("Pick from one of five valid options\n");
		System.out.println("PERSHULT beats KLYKET, SKADIS");
		System.out.println("KLYKET beats TJUSIG, HOVOLM");
		System.out.println("TJUSIG beats PERSHULT, SKADIS");
		System.out.println("SKADIS beats HOVOLM, KLYKET");
		System.out.println("HOVOLM beats PERSHULT, TJUSIG");
		System.out.println();
	}
	
	// Play game
	public static void initGame() {
		
		// Print rules to screen
		rules();
		
		// Initialize empty variables
		char play = ' ';
		int numRounds = 0;
		int userWins = 0;
		int computerWins = 0;
		int userError = 0;
		int winner = 0;
		
		while (play != 'n') {
			
			// Initialize scanner
			Scanner key = new Scanner(System.in);
			// Get user input
			System.out.print("Would you like to play Uppfora? (y/n) ");
			play = Character.toLowerCase(key.next().charAt(0));
			System.out.println();
			
			// Check user input
			while (play != 'y' && play != 'n') {
				System.out.print("Invalid response, would you like to play Uppfora? (y/n) ");
				play = Character.toLowerCase(key.next().charAt(0));
				userError++;
				System.out.println();
			}
			
			
			// Exit game
			if (play == 'n') {
				endGame(numRounds, userWins, computerWins, userError);
			} else {
				// Play game, increment rounds and winner OR invalid user entry, no increment
				winner = playGame();
				numRounds++;
				if (winner == 1) {
					userWins++;
				} else if (winner == 0) {
					computerWins++;
				} else {
					userError++;
					System.out.println("Invalid user entry\n");
				}
			}
		}	
	}
	
	public static int playGame() {
			Scanner key = new Scanner(System.in);
			String userEntry = "";
			String computerEntry = "";
			int computer = 0;		
			
			// Generate random num and switch to string
			Random r = new Random();
			computer = r.nextInt(5);
			
			switch (computer) {
				case 0 :
					computerEntry = "PERSHULT";
					break;
				case 1 :
				    computerEntry = "KLYKET";
				    break;
				case 2 :
					computerEntry = "TJUSIG";
					break;
				case 3 :
				    computerEntry = "SKADIS";
				    break;
				case 4 :
					computerEntry = "HOVOLM";
					break;
				default :
				    computerEntry = "ERROR";
				    break;
			}
			
			// User selection
			System.out.print("Make your selection: ");
			userEntry = key.next().toUpperCase();
			System.out.println();
			
			// Check user entry, return -1 if invalid
			if (!checkEntry(userEntry)) {
				return -1;
			}
			
			// Check winners
			if (checkWinner(userEntry, computerEntry)) {
				return 1;
			} else {
				return 0;
			}
		}
	
	public static boolean checkEntry(String user) {
		String[] options = {"PERSHULT", "KLYKET", "TJUSIG", "SKADIS", "HOVOLM"};
		for (int i = 0; i < options.length; i++) {
			if (user.equals(options[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkWinner(String user, String computer) {
		// Print selections
		System.out.println("User: " + user + " vs " + "Computer: " + computer + "\n");
		
		// Print outcome
		if (user.equals(computer)) {
			// Tie Game
			System.out.println("Tie! Computer wins\n");
			return false;
		} else if (computer.equals("PERSHULT") && (user.equals("KLYKET") || user.equals("SKADIS")) ||
				   computer.equals("KLYKET") && (user.equals("TJUSIG") || user.equals("HOVOLM")) ||
				   computer.equals("TJUSIG") && (user.equals("PERSHULT") || user.equals("SKADIS")) ||
				   computer.equals("SKADIS") && (user.equals("HOVOLM") || user.equals("KYLKET")) ||
				   computer.equals("HOVOLM") && (user.equals("PERSHULT") || user.equals("TJUSIG"))) {
			System.out.println(computer + " beats " + user + "...you lose!\n");
			return false;
		} else {
			System.out.println(user + " beats " + computer + "...you win!\n");
			return true;
		}
	}
	
	// User enters 'n', end of game
	public static void endGame(int rounds, int wins, int losses, int error) {
		// Error penalty
		if (error > 2) {
			System.out.println("ERROR PENALTY: " + (error / 3));
			for (int i = 0; i < error / 3; i++) {
				wins--;
			}
		}
		
		// Print winner
		if (wins > losses) {
			System.out.println("YOU WIN\n");	
		} else if (wins == losses) {
			System.out.println("TIE\n");
		} else {
			System.out.println("YOU LOSE\n");
		}
		
		// Statistics
		System.out.println("Rounds played: " + rounds);
		System.out.println("User: " + wins);
		System.out.println("Computer: " + losses);
		System.out.println("User error: " + error);
	}
}
