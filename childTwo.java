import java.util.Random;

public class childTwo extends parentClass
{

    /////////////////////////////////
    //////// CONSTRUCTORS ///////////
    /////////////////////////////////
	public childTwo(int turnsum, Random random, int copyCurrentScore, int playerX, int playerY, int CurrentScoreX, int CurrentScoreY, int returnTurnSum)
	{
		super(turnsum, random, copyCurrentScore, playerX, playerY, CurrentScoreX, CurrentScoreY, returnTurnSum);
	}
	
	public childTwo()
    {
        super();
    }

	/////////////////////////////////
    ////// OVERIDDEN METHOD /////////
    /////////////////////////////////
    //	function name: Simulation 7
	//	purpose: simulates two computers both playing pig against eachother. uses the new stragegy
	//  while the score is less than 80 it uese the normal strategy
	//  while the score is less than 100 but above 81 it uses the new strategy
	static void playingEntireGame() 
	{
		Random random = new Random();
		int playerX = random.nextInt(3 - 1) + 1;
		int playerY = 0;
			
	//	whatever randomly selected player is known as player x
	//	other player is player y
		if (playerX == 1) 
			playerY = 2;
		else 
			playerY = 1;
		
		int CurrentScoreX = 0;
		int CurrentScoreY = 0;
			
		PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY); 
			
		while ((CurrentScoreX <= 100) && (CurrentScoreY <= 100)) 
		{
			if (CurrentScoreX < 80) 
			{
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumX = playOnce(0, random);
				CurrentScoreX += turnSumX;
				PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY); 
			}
			if (CurrentScoreY < 80) 
			{
				System.out.println("Its Player " + playerY + "'s Turn");
				int turnSumY = playOnce(0, random);
				CurrentScoreY += turnSumY;
				PrintPlayerScoreSummary(playerX, playerY, CurrentScoreX, CurrentScoreY);
			}
			if (CurrentScoreX < 100) 
			{
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumX = playOnce81to100(0, random, CurrentScoreX);
				CurrentScoreX += turnSumX;
			}
			if (CurrentScoreY < 100) 
			{
				System.out.println("Its Player " + playerX + "'s turn");
				int turnSumY = playOnce81to100(0, random, CurrentScoreY);
				CurrentScoreY += turnSumY;
			}
		}
				
		System.out.println("Final Score " + CurrentScoreX + " vs " + CurrentScoreY);
		if (CurrentScoreX < CurrentScoreY) 
		{
			System.out.println("Player " + playerX + " Wins!");
		}	
		else 
		{
			System.out.println("Player " + playerY + " Wins!");
		}
	}
		
}
