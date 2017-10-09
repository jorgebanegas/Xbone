/*=============================================================================  
|   Source code:  [TriangleTester.java]
|           Author:  [Reinol Diaz] 
|     Student ID:  [2923555]  
|    Assignment:  Program #[2] [Triangles]
|  
|            Course:  [COP3337 (Programming 2)]  
|           Section:  [U01]  
|        Instructor:  William Feild  
|        Due Date:  [9/28/2017], at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  [java] 
|  Compile/Run:  [How to Compile and Execute this program, IN DETAIL.] 
| 	javac TriangleTester.java  Triangle.java
|	java TriangleTester
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  [Describe the program's goal, IN DETAIL.]  
|                  
|        Input:  [Program will prompt a user to provide x- and y-coordinates for   
|                 the three Points of a triangle]  
|  
|       Output:  [Output will include the triangle name and all three Points,    
|                 the lengths of all three sides, the three angles at the corners,   
|  				  the perimeter and the area of the triangle, and whether the triangle 
|                 is Equilateral or Right-angled]
|
|
|     Process:  [1) The user is prompted to input the x<return>y of each point  
|                2) The values of the triangle formed by these three points is computed]  
|  
|   Required Features Not Included:  
|                [All features included except triangle name because in class  
|                 we decided it was an unnecessary value since there was only one triangle]  
|  
|   Known Bugs:  [None I could find]  
|  *===========================================================================*/


import java.util.*;

public class TriangleTester 
{

	public static void main(String[]args)
	{
		
	printData( makeTriangle() );
	
	}
	
	
	
	public static void printData(Triangle t)
	{
		System.out.println();
		System.out.println("Your first point is  : ( " + ( t.getXOne() + " , " + t.getYOne() ) + ")" );
		System.out.println("Your Second point is : ( " + ( t.getXTwo() + " , " + t.getYTwo() ) + ")" );
		System.out.println("Your Third point is  : ( " + ( t.getXThree() + " , " + t.getYThree() ) + ")" );
		System.out.println();
		System.out.println("Your triangle is " + t.getTriangleType());
		System.out.println();
		System.out.println("The length from point one to point two is   : " + Math.round (t.getLengthOne() * 10000.0) / 10000.0 + " units");
		System.out.println("The length from point two to point three is : " + Math.round (t.getLengthTwo() * 10000.0) / 10000.0 + " units");
		System.out.println("The length from point three to point one is : " + Math.round (t.getLengthThree() * 10000.0) / 10000.0 + " units");
		System.out.println();
		System.out.println("The angle between side One and Two is   : " +  Math.round (t.getAngleOne() )  + " degrees");
		System.out.println("The angle between side Two and Three is : " +  Math.round (t.getAngleTwo() )  + " degrees");
		System.out.println("The angle between side Three and One is : " +  Math.round (t.getAngleThree() ) + " degrees");
		System.out.println();
		System.out.println("The perimiter of this triangle is  : " + Math.round (t.getPerimiter() * 10000.0) / 10000.0 + " units");
		System.out.println();
		System.out.println("The area of this triangle is  : " + Math.round (t.getArea() * 10000.0) / 10000.0 + " units");
		
	}
	
	public static Triangle makeTriangle()
	{
		double x1,x2,x3,y1,y2,y3;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter point 1 in format x " + "<Return>" + " y");
		
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n\nType the double-type number:");
			sc.next();
			}	
			x1 = sc.nextDouble();
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n\nType a double-type number:");
			sc.next();
			}
			y1= sc.nextDouble();
			System.out.println("Enter point 2 in format x " + "<Return>" + " y");
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n\nType a double-type number:");
			sc.next();
			}
			x2 = sc.nextDouble();
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n\nType a double-type number:");
			sc.next();
			}
			y2= sc.nextDouble();
			System.out.println("Enter point 3 in format x " + "<Return>" + " y");
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n\nType a double-type number:");
			sc.next();
			}
			x3 = sc.nextDouble();
		while (!sc.hasNextDouble())
			{
			System.out.println("Invalid input\n Type the double-type number:");
			sc.next();
			}
			y3= sc.nextDouble();
	
	Triangle t = new Triangle(x1,y1,x2,y2,x3,y3);
	
	return t;
	}

}