/*=======================================================================
|   Source code:  Craps.java
|
|              Class: [Craps.java] 
|
|           Author:  [Reinol Diaz]
|     Student ID:  [2923555]
|    Assignment:  Program #3 - Craps
|  
|            Course:  COP 3337 (Programming 2)
|           Section:  U01
|        Instructor:  William Feild  
|        Due Date:  10/12/2017, by the end of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  [Java]
|  Compile/Run: 
| 	javac Analyzer.java  Craps.java Die.java
|	java Analyzer
|
|        Purpose:  [This class simulates a Craps game by rolling two die over and over]
|
|  Inherits From:  [None]
|
|     Interfaces:  [N/a]
|
| +-----------------------------------------------------------------------
|
|      Constants:  [None]
|					
|	   Equations:  [None]
| +-----------------------------------------------------------------------
|
|   Constructors:  [game creation - which creates an array simulated 
| 						version of a craps game]
|
|  Class Methods:  [playGame	 
|					addTheDice]
|
|  Instance Methods:   [getResult			void 		boolean		
|						getRollCount		void		int
|						getTotalLosses 		void		int
|						getTotalWins		void		int
|						getOpenWin			void		int
|						getOpenLoss			void		int
|						resetGame			void]
|						
|  *===========================================================================*/
public class Craps 
{
Die dieOne = new Die ();
Die dieTwo = new Die ();

int sides = 6;
int rollCount = 0;
int Sum = 0;
int value = 0;
int point = 0;
int totalWins = 0;
int totalLosses = 0;
int openWin = 0;
int openLoss = 0;

boolean result;

	public static Craps[] gameCreation ( int ammountOfGames ) // simulates the games and creates game objects
	{
		Craps[] Games = new Craps [ ammountOfGames + 1 ];
	
		for ( int currentGame = 0 ; currentGame < ammountOfGames ; currentGame++ )
		{
			Games [currentGame] = new Craps();
			Games [currentGame].playGame();
		}
	return Games;
	}


	public boolean playGame()	// simulates the game of craps
	{
		resetGame ();
	dieOne.rollDie (6);
	dieTwo.rollDie (6);
	rollCount ++;
	point = addTheDice ();
		
		if (point == 7 || point == 11)
		{
			result = true;
			totalWins ++;
			openWin ++;
			//Printer(result);
		}
		else 
		{
			if ( point == 2 || point == 3 || point == 12 )
			{ 
				result = false;
				totalLosses ++;
				openLoss ++;
				//Printer(result);
			}
			else
			{
				do
				{
					dieOne.rollDie (6);
					dieTwo.rollDie (6);
					rollCount ++;
					value = addTheDice();
				}
				while ( value != point & value != 7 );
			
					if ( value == point )
					{
						result = true;
						totalWins ++;
						//Printer(result);	
					}
					else 
					{
						result = false;
						totalLosses ++;
						//Printer(result);
					}					
			}
						
		}		
		return true;		
	}
	
	
	//private void Printer(boolean result)
	//{
	//	if(result == true)
	//	{
	//		System.out.println("you have won on roll : " + rollCount);
	//	}
	//	else 
	//		System.out.println("you have lost on roll: " + rollCount);		
	//}
	
	
	private int addTheDice ()	//adds the two dice rolled
	{
	Sum = dieOne.getDie () + dieTwo.getDie ();
	return Sum;	
	}
	
	
	public boolean getResult ()  //returns the result of the game
	{
	return result;
	}
	public int getRollCount ()  //returns the roll count
	{
	return rollCount;
	}
	public int getTotalLosses ()  //returns the total losses
	{
	return totalLosses;
	}
	public int getTotalWins ()  //returns the total wins
	{
	return totalWins;
	}
	public int getOpenWin ()  //returns the opening wins
	{
	return openWin;
	}
	public int getOpenLoss ()  //returns the opening losses
	{
	return openLoss;
	}
	  
	
	
	public void resetGame ()	// not sure how this is relevant to the program but it was in the specs XD
	{
	sides = 6;
	rollCount = 0;
	Sum = 0;
	value = 0;
	point = 0;
	totalWins = 0;
	totalLosses = 0;
	openWin = 0;
	openLoss = 0;
	}
	
	
}
