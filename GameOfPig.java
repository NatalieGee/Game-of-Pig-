import java.util.Random;
import java.util.Scanner;

public class GameOfPig {

//	function name: menu
//	purpose: prints menu
	static int menu(){
		System.out.println("Hello. Welcome to the Game of Pig");
		System.out.println("Select any option from below");
		System.out.println("	1. Simulation 1: Rolling a die");
		System.out.println("	2. Simulation 2: Expected Value");
		System.out.println("	2. Simulation 3: Expected Rolls");
		System.out.println("	4. Simulation 4: The Computer's Turn");
		System.out.println("	5. Simulation 5: The Computer's Strategy");	
		System.out.println("	6. Simulation 6: The Solitaire Pig");
		System.out.println("	7. Simulation 7: Computer vs Computer");	
		System.out.println("	8. Exit");
		System.out.println("Enter the option: ");	
		
		Scanner scanMan = new Scanner(System.in);
		int number = scanMan.nextInt();
		return number;
	}
	
//	function name:: playOnce
//	purpose: simulates one single play of pig by one single player
//	meant to reduce the anount of code needed in this program
	static int playOnce(int turnSum, Random random) {
		while (turnSum <= 20) {
			int rollOnce = random.nextInt(7 - 1) + 1;
			System.out.println("-rolled a " + rollOnce);
			turnSum += rollOnce;
			if (rollOnce == 1) {
				System.out.println("Pigged out!");
				System.out.println("Turn Score = 0");
				System.out.println("");
				return 0;
			}
		}	
		System.out.println("Turn Score = " + turnSum);
		System.out.println("");
		return turnSum;
	}

//	function name: playOnce81to100
//	purpose: simulates one single play of pig by one single 
//	player using the modified strategy introduced in question 5 
	static int playOnce81to100(int turnSum, Random random, int copyCurrentScore) {
		while (turnSum < (100-copyCurrentScore)) {	
		int rollOnce = random.nextInt(7 - 1) + 1;
			System.out.println("-rolled a " + rollOnce);
			turnSum += rollOnce;
			if (rollOnce == 1) { 
				System.out.println("Pigged out!");
				System.out.println("Turn Score = " + turnSum);
				return 0;
			}
		}
		System.out.println("Turn Score = " + turnSum);
		System.out.println("");
		return turnSum;
		}
	
//	function name: PrintPlayerScoreSummary
//	purpose: prints the scores of two players
//	meant for question 7
	static void PrintPlayerScoreSummary(int playerX, int playerY, int CurrentScoreX, int CurrentScoreY) {
		System.out.println("Player " + playerX + "'s score: " + CurrentScoreX);
		System.out.println("Player "+ playerY + "'s score: " + CurrentScoreY );
		System.out.println("");
	}

//	function name: Simulation 1
//	purpose: rolls a 6 sided die and prints the value of the roll
	static void Simulation1() {
		Random random = new Random();
		int rollOnce = random.nextInt(7 - 1) + 1;		
		System.out.println("-rolled a " + rollOnce);
	}
	
//	function name: Simulation 2
//	purpose: calculates and prints expected value
	static void Simulation2() {
//		ask user for how many rolls they want to make and store that number
		System.out.println("What is the number of rolls to simulate?: ");
		Scanner scanner = new Scanner(System.in);
		int numberOfrolls = scanner.nextInt();
		System.out.println("Rolling " + numberOfrolls + " times...");
		
//		make a new random object
//		make a grandTotal object store sum of all rolls
		Random random = new Random();
		int turnSum = 0;
		
//		for loop to add all the rolls results together
		for (int index = 0; index < numberOfrolls + 1; index ++) {	
			int rollOnce = random.nextInt(7 - 1) + 1;
			turnSum += rollOnce;
		}
		
//		divide grandTotal by input to get expected value
		System.out.println("Estimated Expectation: "+ (double) turnSum/numberOfrolls);
	}
	
//	function name: Simulation 3
//	purpose: tests how many dies you can expect to make in a turn of pig before rolling a 1
//	uses use input for how many rolls are performed (size of sample space)	
	static void Simulation3() {
//		ask user for how many rolls they want to make and store that number
		System.out.println("What is the number of rolls to simulate?: ");
		Scanner scanner = new Scanner(System.in);
		double numberOfrolls = scanner.nextInt();
		System.out.println("Rolling " + numberOfrolls + " times...");
		
		int pigOutCount = 0;
		
		for (int index = 0; index < numberOfrolls + 1; index ++) {
			Random random = new Random();
			int rollOnce = random.nextInt(7 - 1) + 1;	
			if (rollOnce == 1) { pigOutCount++;}
		}

		double estimatedExpectation = pigOutCount/numberOfrolls;
		System.out.println("Estimated Expectation: " + pigOutCount + "/" + numberOfrolls + " or " + estimatedExpectation);
	}

//	function name: Simulation 4
//	purpose: simulates a single player's turns of the game pig. 
//  It calls the playOnce function to do that
	static void Simulation4() {
		Random random = new Random();
		int turnSum = 0;
//		call the play once function
		int returnTurnSum = playOnce(turnSum, random);
		}
	
//	function name: Simulation 5
//	purpose: takes in an input and simulates a single turn of pig if the input is above 81
//	or it can simulate a whole game of pig if the input is 0.
//	uses a new stragety: when the players score is above 81 there is no need to hold at 20. you can hold at 19
//	as long as the players score is between 81 -100 the game will use the new strategy
	static void Simulation5() {
		System.out.println("What is the current Score? ");
		Scanner scanner = new Scanner(System.in);
		int currentScore = scanner.nextInt();
		int copyCurrentScore = currentScore;
		
		Random random = new Random();
		
		while (copyCurrentScore <= 80) {
			int returnTurnScore = playOnce(0, random);
			copyCurrentScore += returnTurnScore;
		}
		while (copyCurrentScore <= 100) {
			int returnTurnSum = playOnce81to100(0, random, copyCurrentScore);
			copyCurrentScore += returnTurnSum;
		}
		System.out.println("You win: your score is " + copyCurrentScore);
	}
		
//	function name: Simulation 6
//	purpose: simulates a single player playing pig by themselves. uses the new strategy
//  while the score is less than 80 it uese the normal strategy
//  while the score is less than 100 but above 81 it uses the new strategy
	static void Simulation6() {
		int currentScore = 0;
		int copyCurrentScore = currentScore;
		
		Random random = new Random();
		int turnSum = 0;
		
		while (copyCurrentScore <= 80) {
			int returnTurnScore = playOnce(0, random);
			copyCurrentScore += returnTurnScore;
		}
		while (copyCurrentScore <= 100) {
			int returnTurnSum = playOnce81to100(0, random, copyCurrentScore);
			copyCurrentScore += returnTurnSum;
		}
		System.out.println("You win: your score is " + copyCurrentScore);
	}
	
//	function name: Simulation 7
//	purpose: simulates two computers both playing pig against eachother. uses the new stragegy
//  while the score is less than 80 it uese the normal strategy
//  while the score is less than 100 but above 81 it uses the new strategy
	static void Simulation7() {
		Random random = new Random();
		int playerX = random.nextInt(3 - 1) + 1;
		int playerY = 0;
		
//		whatever randomly selected player is known as player x
//		other player is player y
		if (playerX == 1) 
			playerY = 2;
		else 
			playerY = 1;
		
		int CurrentScoreX = 0;
		int CurrentScoreY = 0;
		
		PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY); 
		
		while ((CurrentScoreX <= 100) && (CurrentScoreY <= 100)) {
			if (CurrentScoreX < 80) {
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumX = playOnce(0, random);
				CurrentScoreX += turnSumX;
				PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY); 
			}
			if (CurrentScoreY < 80) {
				System.out.println("Its Player " + playerY + "'s Turn");
				int turnSumY = playOnce(0, random);
				CurrentScoreY += turnSumY;
				PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY);
			}
			if (CurrentScoreX < 100) {
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumX = playOnce81to100(0, random, CurrentScoreX);
				CurrentScoreX += turnSumX;
			}
			if (CurrentScoreY < 100) {
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumY = playOnce81to100(0, random, CurrentScoreY);
				CurrentScoreY += turnSumY;
			}
		}
			
		System.out.println("Final Score " + CurrentScoreX + " vs " + CurrentScoreY);
		if (CurrentScoreX < CurrentScoreY) 
			System.out.println("Player " + playerX + " Wins!");
		else {
			System.out.println("Player " + playerY + " Wins!");
		}
	}
	
//	function name: main
//	purpose: continues to prompt use to input a number 1-7 inclusive to play problems
//	calls corresponding problem functions the player input
	public static void main(String[] args) {
		int number = menu();
		
//		if statemnts to call the problem functions based on whatever the input is: 
//		if number = 1-8 call function "problem8" - "problem8"
		while (number != 8) {
			if (number == 1) {Simulation1();}
			if (number == 2) {Simulation2();}
			if (number == 3) {Simulation3();}
			if (number == 4) {Simulation4();}
			if (number == 5) {Simulation5();}
			if (number == 6) {Simulation6();}
			if (number == 7) {Simulation7();}
			System.out.println("----------------------------------------------");
			number = menu();
		}
	}

	
	
	
	
	
	}