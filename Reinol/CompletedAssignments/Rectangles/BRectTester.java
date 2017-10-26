/*=============================================================================  
|   Source code:  [BRectTester.java]
|           Author:  [Reinol Diaz] 
|     Student ID:  [2923555]  
|    Assignment:  Program #[4] [Triangles]
|  
|            Course:  [COP3337 (Programming 2)]  
|           Section:  [U01]  
|        Instructor:  William Feild  
|        Due Date:  [10/26/2017], at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  [java] 
|  Compile/Run:  [How to Compile and Execute this program, IN DETAIL.] 
| 	javac BRectTester.java  BetterRectangle.java
|	java BRectTester
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  [Describe the program's goal, IN DETAIL.]  
|                  
|        Input:  [Creates 4 rectangles and tests the BetterRectangle class]  
|  
|       Output:  [Output will show proof that the added methods to the sub 
|					class are working properly]
|
|
|     Process:  [Runs through print statements to show proof]  
|  
|   Required Features Not Included:  
|                [All features included ]  
|  
|   Known Bugs:  [None]  
|  *===========================================================================*/
import java.awt.Point;

public class BRectTester 
{

	public static void main (String[] args)
	{
		// creates rectangles
		BetterRectangle bRectA = new BetterRectangle( 4 , 3 );
		BetterRectangle bRectB = new BetterRectangle( bRectA );
		BetterRectangle bRectC = new BetterRectangle( 1 , 1 , 3 , 4 );
		BetterRectangle bRectD = new BetterRectangle();
		
		System.out.println("TESTER RECTANGLE LIST :");
		System.out.println("");
		System.out.println( "Rectangle A : " + bRectA.toString() );
		System.out.println( "Rectangle B : " + bRectB.toString() );
		System.out.println( "Rectangle C : " + bRectC.toString() );
		System.out.println( "Rectangle D : " + bRectD.toString() );
		
		System.out.println("______________________________________________________________________________________________________________________________________________");
		
		
		System.out.println("WE WILL NOW COMPARE SEVERAL ASPECTS OF TRIANGLE B AND C :");
		System.out.println();
		System.out.println( "Rectangle B : " + bRectB.toString() );
		System.out.println( "Rectangle C : " + bRectC.toString() );
		
		System.out.println();
		
		//Utility Tests
		boolean UtilityTest1 = bRectB.equals( bRectC );
		System.out.println( "B is equal      to C : " + UtilityTest1 );
		
		boolean UtilityTest2 = bRectB.congruent( bRectC );
		System.out.println( "B is congruent  to C : " + UtilityTest2 );
		
		boolean UtilityTest3 = bRectB.equivalent( bRectC );
		System.out.println( "B is equivalent to C : " + UtilityTest3 );
		
		boolean UtilityTest4 = bRectB.similar( bRectC );
		System.out.println( "B is similar    to C : " + UtilityTest4 );
		
		boolean UtilityTest5 = bRectB.concentric( bRectC );
		System.out.println( "B is concentric to C : " + UtilityTest5 );
		
		System.out.println("______________________________________________________________________________________________________________________________________________");
		
		
		System.out.println("WE WILL NOW GET SEVERAL ASPECTS OF RECTANGLE A :");
		System.out.println();
		System.out.println( "Rectangle A : " + bRectA.toString() );
		System.out.println();
		
		//Accessor tests
		int area = bRectA.getArea();
		System.out.println( "area       : " + area );
		int perimeter = bRectA.getPerimeter();
		System.out.println( "perimeter  : " + perimeter );
		float slope = bRectA.getSlope();
		System.out.println( "slope      : " + slope );
		Point midPoint = bRectA.getMidPoint();
		System.out.println( "mid point  : " + midPoint );
		
		System.out.println("______________________________________________________________________________________________________________________________________________");
		
		
		System.out.println( "WE WILL NOW ATTEMPT TO SCALE RECTANGLE D BY 3 AND THEN -3 :");
		System.out.println();
		System.out.println( "Rectangle D : " + bRectD.toString() );
		System.out.println();
		
		//Mutator tests
		System.out.println( "Before scale by 3: " + bRectD.toString() );
		boolean mutatorTest1 = bRectD.scaleBy( 3 );
		System.out.println( "After  scale by 3: " + bRectD.toString() );
	
		System.out.println( "Result of scale  : " + mutatorTest1);
		
		System.out.println();
		
		System.out.println( "Before scale by -3: " + bRectD.toString() );
		boolean mutatorTest2 = bRectD.scaleBy( -3 );
		System.out.println( "After  scale by -3: " + bRectD.toString() );
	
		System.out.println( "Result of scale   : " + mutatorTest2);
		System.out.println("______________________________________________________________________________________________________________________________________________");
		
	}
}
	