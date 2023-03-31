import java.util.Random;

public class childOne extends parentClass
{

    /////////////////////////////////
    //////// CONSTRUCTORS ///////////
    /////////////////////////////////
	public childOne(int turnsum, Random random, int copyCurrentScore, int playerX, int playerY, int CurrentScoreX, int CurrentScoreY, int returnTurnSum)
	{
		super(turnsum, random, copyCurrentScore, playerX, playerY, CurrentScoreX, CurrentScoreY, returnTurnSum);
	}
	
	public childOne()
    {
        super();
    }

	/////////////////////////////////
    ////// OVERIDDEN METHOD /////////
    /////////////////////////////////
	//	function name: single Turn
	//	purpose: takes in an input and simulates a single turn of pig if the input is above 81
	//	or it can simulate a whole game of pig if the input is 0.
	//	uses a new stragety: when the players score is above 81 there is no need to hold at 20. you can hold at 19
	//	as long as the players score is between 81 -100 the game will use the new strategy
	static void singleTurn() 
	{
		System.out.println("What is the current Score? ");
		Scanner scanner = new Scanner(System.in);
		int currentScore = scanner.nextInt();
		int copyCurrentScore = currentScore;
			
		Random random = new Random();
			
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