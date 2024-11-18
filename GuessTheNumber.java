package GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	// Method to start the game
	
	public static void startGame(int rounds, int maxAttempts) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int totalScore = 0;

		// Loop through the number of rounds
		
		for (int round = 1; round <= rounds; round++) {
			System.out.println("\n### Round " + round + " ###");
			int randomNumber = random.nextInt(100) + 1; 
			
			// Generate random number between 1 and 100
			
			int attempts = 0;
			boolean hasGuessed = false;

			// Allow the user to guess within the limit of attempts
			
			while (attempts < maxAttempts) {
				System.out.print("Enter your guess (1-100): ");
				int userGuess = scanner.nextInt();
				attempts++;

				if (userGuess == randomNumber) {
					System.out.println("Congratulations! You guessed the correct number.");
					hasGuessed = true;
					totalScore += (maxAttempts - attempts + 1); 
					
					
					
					System.out.println("Points for this round: " + (maxAttempts - attempts + 1));
					break;
				} else if (userGuess < randomNumber) {
					System.out.println("Your guess is lower than the num.");
				} else {
					System.out.println("Your guess is higher than the num.");
				}

				System.out.println("Remaining attempts: " + (maxAttempts - attempts));
			}

			if (!hasGuessed) {
				System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
			}
		}

		// Display the final score after all rounds
		
		System.out.println("\nGame Over! Your total score is: " + totalScore);
		scanner.close();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Get user inputs for rounds and max attempts
		
		System.out.println("Welcome to Guess the Number Game!");
		System.out.print("Enter the num of rounds you want to play: ");
		int rounds = scanner.nextInt();
		System.out.print("Enter the maximum num of attempts per round: ");
		int maxAttempts = scanner.nextInt();

		// Start the game
		
		startGame(rounds, maxAttempts);
	}
}
