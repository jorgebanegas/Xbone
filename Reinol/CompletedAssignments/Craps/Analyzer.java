/*=============================================================================  
|   Source code:  [Analzer.java]
|           Author:  [Reinol Diaz] 
|     Student ID:  [2923555]  
|    Assignment:  Program #[3] [Craps]
|  
|            Course:  [COP3337 (Programming 2)]  
|           Section:  [U01]  
|        Instructor:  William Feild  
|        Due Date:  [10/12/2017], at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  [java] 
|  Compile/Run:  [How to Compile and Execute this program, IN DETAIL.] 
| 	javac Analyzer.java  Craps.java Die.java
|	java Analyzer
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  [Simulates a desired number of non betting Craps games and analyzes the results]  
|                  
|        Input:  [Program will prompt a user to provide an amount of games to be analyzed]    
|  
|       Output:  [Output will include several statistics about the games that were simulated]
|
|
|     Process:  [1) The user is prompted to input the amount of games  
|                2) The games are simulated  
|				 3) The values are analyzed]
|  
|   Required Features Not Included:  
|                [All features included]  
|  
|   Known Bugs:  [None I could find]  
|  *===========================================================================*/

import java.text.DecimalFormat; // to format my output
import java.util.Scanner; //to be able to take in input

public class Analyzer 
{
	public static void main(String[] args) // runs program 
	{
		int ammountOfGames = input ();
		printer( ammountOfGames , gameCreation (ammountOfGames ) );	
	}
	
	
	public static int input ()	//accepts input and verifies it
	{
		Scanner sc = new Scanner ( System.in );
		System.out.println( "How many games would you like to analyze ( between 1 and 1,000,000 inclusive)" );
	
		int ammountOfGames = 0;
		do 
		{
			System.out.println ( "Please enter a whole integer value." );
		    while ( !sc.hasNextInt () ) 
		    {
		        sc.nextLine (); // Clears the invalid input
		        System.out.println ( "Invalid Input! Please enter a whole integer value." );
		    }
		    ammountOfGames = sc.nextInt ();
		} while ( ! ( ammountOfGames > 0 && ammountOfGames <= 1000000 ) );
		
		return ammountOfGames;
	}
	
	
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

	public static void printer ( int ammountOfGames , Craps[] Games ) 
	{
		DecimalFormat df = new DecimalFormat ( "0.00000" );
		
		double totalRolls = 0;
		double totalWins = 0;
		double totalLosses = 0;
		double openWin = 0;
		double openLoss = 0;
		double comingOutTotal = 0;
		int highestRoll = 0;
		int temp = 0;
		int placeHolder = 0;
		
		int [] tally = new int[ ammountOfGames+1 ];
		int [] count = new int[ ammountOfGames+1 ];
		
		
		for ( int currentGame = 0 ; currentGame < ammountOfGames ; currentGame++ )
		{
		tally [ currentGame ] = Games[ currentGame ].getRollCount ();
			
		totalRolls = totalRolls + Games [ currentGame ].getRollCount ();
		totalWins = totalWins + Games [ currentGame ].getTotalWins ();
		totalLosses = totalLosses + Games [ currentGame ].getTotalLosses ();
		openWin = openWin + Games [ currentGame ].getOpenWin ();
		openLoss = openLoss + Games [ currentGame ].getOpenLoss ();
		comingOutTotal = openWin + openLoss;
		
		if ( highestRoll < Games [ currentGame ].getRollCount () )
			{
			highestRoll = Games [ currentGame ].getRollCount ();
			}
		
		}
		
		
		
		// the multiplication by 100 is to turn the decimal to a percent
		System.out.println ("" );
		System.out.println (" 1) The total number of games in this simulation is: " + ammountOfGames);
		System.out.println (" 2) The total number of rolls in all games is: " + totalRolls);
		System.out.println ("");
		System.out.println ("");
		System.out.println (" 3) Tally of how long each game lasted: ");
		System.out.println ("");
		
		for ( placeHolder = 0 ; placeHolder < tally.length ; placeHolder ++ )
		{
            temp = tally [ placeHolder ];
            count [ temp ] ++;
        }
		for ( placeHolder = 1 ; placeHolder < count.length ; placeHolder ++ )
		{
		        if ( count [ placeHolder ] > 0 && count [ placeHolder ] == 1 )
		        {
		        	System.out.printf( "%2d occurs %6d times\n" , placeHolder , count [ placeHolder ] );
		        }
		        else 
		        if ( count [ placeHolder ] >= 2 )
		        {
		            System.out.printf( "%2d occurs %6d times\n" , placeHolder , count [ placeHolder ] );
		        }
		}
		System.out.println ( "" );
		System.out.println ( " 4) The average length of the games: " + df.format(totalRolls/ammountOfGames) + " rolls" );
		System.out.println ( "" );
		System.out.println ( " 5) The expected probability of winning in this simulation is: 49.30000% " ); // value found via simple probability and statistics
		System.out.println ( " 6) The outcome of winning overall is: " + df.format( (totalWins / ammountOfGames) *100 ) + "%" );
		System.out.println ( "" );
		System.out.println ( " 7) The total number of wins on the opening roll is: " + openWin );
		System.out.println ( " 8) The expected probability of winning on the coming out roll is: 22.22222 % " ); // value found via simple probability and statistics
		System.out.println ( " 9) The outcome of winning on the coming out in this simulation is:" + df.format ( (openWin / comingOutTotal) * 100 ) + "%" );
		System.out.println ( "" );
		System.out.println ( "10) The total number of losses on the opening roll is: " + openLoss );
		System.out.println ( "11) The expected probability of losing on the coming out roll is: 11.11111% " ); // value found via simple probability and statistics
		System.out.println ( "12) The outcome of losing on the coming out roll in this simulation is: "+ df.format ( (openLoss / comingOutTotal ) * 100 ) + "%" );
		System.out.println ( "" );
		System.out.println ( "13) The expected probability of the games ending on the coming out roll is: 33.33333%  " ); // value found via simple probability and statistics
		System.out.println ( "14) The outcome of the game ending on the coming out roll is: "+ df.format ( ( comingOutTotal / ammountOfGames ) * 100 ) + "%" );
		System.out.println ( "" );
		System.out.println ( "15) The expected probability of the game continuing after the coming out roll is: 66.66666% " ); // value found via simple probability and statistics
		System.out.println ( "16) The outcome of the games continuing after the coming out roll is: " +  df.format ( ( totalWins - openWin ) / ( totalLosses - openLoss ) * 100 ) + "%" );
		System.out.println ( "" );
		System.out.println ( "17) The longest game played was: " + highestRoll + " rolls" );
		
		
		
		
	}
	
	
}



