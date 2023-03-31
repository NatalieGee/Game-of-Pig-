import java.util.Random;
import java.util.Scanner;

public class parentClass extends mainClass
{

	/////////////////////////////////
	////// INSTANCE VARIABLES ///////
	/////////////////////////////////
    int turnsum;
	Random random;
	int copyCurrentScore;
	int playerX;
	int playerY;
	int CurrentScoreX;
	int CurrentScoreY;

	/////////////////////////////////
    //////// CONSTRUCTORS ///////////
    /////////////////////////////////
	public parentClass(int turnsum, Random random, int copyCurrentScore, int playerX, int playerY, int CurrentScoreX, int CurrentScoreY, int returnTurnSum)
	{
        super(returnTurnSum);
        this.turnsum = turnsum;
        this.random = random;
        this.copyCurrentScore = copyCurrentScore;
        this.playerX = playerX;
        this.playerY = playerY;
        this.CurrentScoreX = CurrentScoreX;
        this.CurrentScoreY = CurrentScoreY;
    }

    public parentClass()
    {
        super();
    }

    /////////////////////////////////
    /////////// METHODS /////////////
    /////////////////////////////////
//	function name:: playOnce
//	purpose: simulates one single play of pig by one single player
//	meant to reduce the anount of code needed in this program
	static int playOnce(int turnSum, Random random) 
    {
		while (turnSum <= 20) 
        {
			int rollOnce = random.nextInt(7 - 1) + 1;
			System.out.println("-rolled a " + rollOnce);
			turnSum += rollOnce;
			if (rollOnce == 1) 
            {
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
//	player using the modified strategy introduced in Simulation 5 
	static int playOnce81to100(int turnSum, Random random, int copyCurrentScore) 
    {
		while (turnSum < (100-copyCurrentScore)) 
        {	
		int rollOnce = random.nextInt(7 - 1) + 1;
			System.out.println("-rolled a " + rollOnce);
			turnSum += rollOnce;
			if (rollOnce == 1) 
            { 
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
//	meant for Simulation 7
static void PrintPlayerScoreSummary(int playerX, int playerY, int CurrentScoreX, int CurrentScoreY) 
{
    System.out.println("Player " + playerX + "'s score: " + CurrentScoreX);
    System.out.println("Player "+ playerY + "'s score: " + CurrentScoreY );
    System.out.println("");
}

//	function name: Simulation 1
//	purpose: rolls a 6 sided die and prints the value of the roll
static void Simulation1() 
{
    Random random = new Random();
    int rollOnce = random.nextInt(7 - 1) + 1;		
    System.out.println("-rolled a " + rollOnce);
}
    
//	function name: Simulation 2
//	purpose: calculates and prints expected value
static void Simulation2() 
{
//	ask user for how many rolls they want to make and store that number
    System.out.println("What is the number of rolls to simulate?: ");
    Scanner scanner = new Scanner(System.in);
    int numberOfrolls = scanner.nextInt();
    System.out.println("Rolling " + numberOfrolls + " times...");
    //	make a new random object
    //	make a grandTotal object store sum of all rolls
    Random random = new Random();
    int turnSum = 0;
    //	for loop to add all the rolls results together
    for (int index = 0; index < numberOfrolls + 1; index ++) 
    {	
        int rollOnce = random.nextInt(7 - 1) + 1;
        turnSum += rollOnce;
    }	
    //	divide grandTotal by input to get expected value
    System.out.println("Estimated Expectation: "+ (double) turnSum/numberOfrolls);
}
    
//	function name: Simulation 3
//	purpose: tests how many dies you can expect to make in a turn of pig before rolling a 1
//	uses use input for how many rolls are performed (size of sample space)	
static void Simulation3() 
{
//	ask user for how many rolls they want to make and store that number
    System.out.println("What is the number of rolls to simulate?: ");
    Scanner scanner = new Scanner(System.in);
    double numberOfrolls = scanner.nextInt();
    System.out.println("Rolling " + numberOfrolls + " times...");
    
    int pigOutCount = 0;
        
    for (int index = 0; index < numberOfrolls + 1; index ++)
    {
        Random random = new Random();
        int rollOnce = random.nextInt(7 - 1) + 1;	
        if (rollOnce == 1) { pigOutCount++;}
    }

    double estimatedExpectation = pigOutCount/numberOfrolls;
    System.out.println("Estimated Expectation: " + pigOutCount + "/" + numberOfrolls + " or " + estimatedExpectation);
}

	//	function name: playerTurn / Simulation 4
	//	purpose: simulates a single player's turns of the game pig. 
	//  It calls the playOnce function to do that
static void singleTurn(int returnTurnSum) 
{
	Random random = new Random();
	int turnSum = 0;
    //	call the play once function
	returnTurnSum = playOnce(turnSum, random);
}
		
	//	function name: Simulation 6
	//	purpose: simulates a single player playing pig by themselves. uses the new strategy
	//  while the score is less than 80 it uese the normal strategy
	//  while the score is less than 100 but above 81 it uses the new strategy
static void playingEntireGame() 
	{
		int currentScore = 0;
		int copyCurrentScore = currentScore;
			
		Random random = new Random();
		int turnSum = 0;
			
		while (copyCurrentScore <= 80) 
		{
			int returnTurnScore = playOnce(0, random);
			copyCurrentScore += returnTurnScore;
		}
		while (copyCurrentScore <= 100) 
		{
			int returnTurnSum = playOnce81to100(0, random, copyCurrentScore);
			copyCurrentScore += returnTurnSum;
		}
		System.out.println("You win: your score is " + copyCurrentScore);
	}
		

}