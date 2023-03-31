import java.util.Scanner;

public class mainClass
{
	public static int returnTurnSum;
	public static Scanner scanMan;

	/////////////////////////////////
    //////// CONSTRUCTORS ///////////
    /////////////////////////////////
	public mainClass(int returnTurnSum)
	{
		mainClass.returnTurnSum = returnTurnSum;
	}

	public mainClass()
	{

	}

	/////////////////////////////////
	///////// MAIN CLASS ////////////
	/////////////////////////////////

    public static void main(String[] args, int number) 
	{
		scanMan = new Scanner(System.in);
		number = scanMan.nextInt();

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
	 
		////////////////////////////////////
		/////////initiate objects/////////// 
		////////////////////////////////////
		parentClass p = new parentClass();
		childOne c1 = new childOne();
		childTwo c2 = new childTwo();

		////////////////////////////////////
		///////// call objects////////////// 
		////////////////////////////////////
		while (number != 8) 
		{
		if (number == 1) {parentClass.Simulation1();}
		if (number == 2) {parentClass.Simulation2();}
		if (number == 3) {parentClass.Simulation3();}
		if (number == 4) {parentClass.singleTurn(returnTurnSum);}
		if (number == 5) {parentClass.playingEntireGame();}
		if (number == 6) {childOne.singleTurn();}
		if (number == 7) {childTwo.playingEntireGame();}
		}
	}
}