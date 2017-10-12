/*=======================================================================
|   Source code:  Die.java
|
|              Class: [Die.java] 
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
|        Purpose:  [This class simulates the rolling of two die]
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
|   Constructors:  [rollDie - which receives two values for the amount of sides]
|
|  Class Methods:  [rollDie  int sides]
|
|  Instance Methods:   [getDie  void  int]
|						
|  *===========================================================================*/
public class Die
{
  private int face = 1;
  
  public void rollDie ( int sides ) // simulates rolling two die
  {
	  face = ( int ) ( Math.random () * sides + 1 );
  }
  
  
  public int getDie ()	// returns the face value of the die in question 
  {
	  return face;
  }
  
}
