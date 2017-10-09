/*=======================================================================
|   Source code:  TriangleTester.java
|
|              Class: [Triangle.java] 
|
|           Author:  [Reinol Diaz]
|     Student ID:  [2923555]
|    Assignment:  Program #2 - Triangles
|  
|            Course:  COP 3337 (Programming 2)
|           Section:  U01
|        Instructor:  William Feild  
|        Due Date:  9/28/2017, by the end of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac TriangleTester.java Triangles.java
|	java TriangleTester
|
|        Purpose:  [This class creates a triangle object and calculates
|                   values for the length of the sides the angles at the 
|                   points area and perimeter of the triangle]
|
|  Inherits From:  [None]
|
|     Interfaces:  [N/a]
|
| +-----------------------------------------------------------------------
|
|      Constants:  [pointOne		contains the (x,y) of point one
|		    pointTwo		contains the (x,y) of point two
|		    pointThree		contains the (x,y) of point three]
|					
|	   Equations:  [ Length from point 1-2 = sqrt( (x2-x1)^2 + (y2-y1)^2)
|			  		 Angle between two lines = acos( (a^2 + b^2 + c^2) / (2*a*b) )
|			  		 s = (a+b+c) / 2
|			  		 Area = sqrt( s * (s-a) * (s-b) * (s-c))
|			  		 Perimeter = a + b + c
| +-----------------------------------------------------------------------
|
|   Constructors:  [Triangle - which takes in the 6 values of the points 
|                   and creates the triangle]
|
|  Class Methods:  [setPointA	 double x1, double y1   Double
|			setPointB	 double x2, double y2	Double
|			setPointC	 double x3, double y3 	Double]
|
|  Instance Methods:   [getXOne		       	void		Double
|			    getXTwo				void		Double
|			    getXThree 			void		Double
|			    getYOne				void		Double
|			    getYTwo				void		Double
|			    getYThree			void		Double
|			    getLengthOne		void		Double
|			    getLengthTwo		void		Double
|			    getLengthThree		void		Double
|			    getAngleOne			void		Double
|			    getAngleTwo			void		Double
|			    getAngleThree		void		Double
|			    getPerimiter		void		Double
|			    getArea				void		Double
|			    getTriangleType]	void		Double
|
|  *===========================================================================*/



import java.awt.geom.Point2D;

public class Triangle 
{
	
	Point2D.Double pointOne = new Point2D.Double();
	Point2D.Double pointTwo = new Point2D.Double();
	Point2D.Double pointThree = new Point2D.Double();

	
	public Triangle( double x1, double y1, double x2, double y2, double x3, double y3 ) 
	{
		pointOne = new Point2D.Double( x1, y1 );
		pointTwo = new Point2D.Double( x2, y2 );
		pointThree = new Point2D.Double( x3, y3 );
	}

	private void setPointA( double x1, double y1 ) 
	{
		pointOne.x = x1;
		pointOne.y = y1;
	}

	private void setPointB( double x2, double y2 ) 
	{
		pointTwo.x = x2;
		pointTwo.y = y2;
	}

	private void setPointC( double x3, double y3 ) 
	{
		pointThree.x = x3;
		pointThree.y = y3;
	}
	
	public double getXOne() 
	{
		return pointOne.x;
	}

	public double getYOne() 
	{
		return pointOne.y;
	}
	public double getXTwo() 
	{
		return pointTwo.x;
	}
	
	public double getYTwo() 
	{
		return pointTwo.y;
	}
	public double getXThree() 
	{
		return pointThree.x;
	}

	public double getYThree() 
	{
		return pointThree.y;
	}
	
	
	
	public double getLengthOne()
	{

		double a = Math.sqrt( ( pointTwo.x - pointOne.x ) * ( pointTwo.x - pointOne.x ) + ( pointTwo.y - pointOne.y ) * ( pointTwo.y - pointOne.y ) );

			return a;
	}
	
	public double getLengthTwo()
	{

		double b = Math.sqrt( ( pointThree.x - pointTwo.x ) * ( pointThree.x - pointTwo.x ) + ( pointThree.y - pointTwo.y ) * ( pointThree.y - pointTwo.y ) );

			return b;
	}
	
	public double getLengthThree()
	{

		double c = Math.sqrt( ( pointOne.x - pointThree.x ) * ( pointOne.x - pointThree.x ) + ( pointOne.y - pointThree.y ) * ( pointOne.y - pointThree.y ) );

			return c;
	}
	
	
	
	public double getAngleOne()
	{

		double angleOne = Math.acos( ( Math.pow( getLengthOne() , 2) + Math.pow( getLengthTwo() , 2) - Math.pow( getLengthThree() , 2) ) / ( 2 * getLengthOne() * getLengthTwo() ) ) ;

			return Math.toDegrees(angleOne);
	}

	public double getAngleTwo()
	{
		
		double angleTwo = Math.acos( ( Math.pow( getLengthTwo() , 2) + Math.pow( getLengthThree() , 2) - Math.pow( getLengthOne() , 2) ) / ( 2 * getLengthTwo() * getLengthThree() ) ) ;

	    	return Math.toDegrees(angleTwo);
	}

	public double getAngleThree()
	{

		double angleThree = Math.acos( ( Math.pow( getLengthThree() , 2) + Math.pow( getLengthOne() , 2) - Math.pow( getLengthTwo() , 2) ) / ( 2 * getLengthThree() * getLengthOne() ) ) ;

			return Math.toDegrees(angleThree);
	}
	
	
	
	public double getPerimiter()
	{

		double perimiter = getLengthOne() + getLengthTwo() + getLengthThree();

			return perimiter;
	}
	
	
	
	public double getArea()
	{

		double halfPerimiter = (getLengthOne() + getLengthTwo() + getLengthThree() ) / 2;
		double area = Math.sqrt( halfPerimiter * ( halfPerimiter - getLengthOne() ) * ( halfPerimiter - getLengthTwo() ) * ( halfPerimiter - getLengthThree() ) );

			return area;
	}
	
	


	
	public String getTriangleType()
	{
		String ans;
		if (getAngleOne() == 90)
		{
			ans = " a right triangle";
			return ans;
		}
		if (getAngleTwo() == 90)
		{
			ans = " a right triangle";
			return ans;
		}
		if (getAngleThree() == 90)
		{
			ans = " a right triangle";
			return ans;
		}
		if (getLengthOne() == getLengthTwo() && getLengthTwo() == getLengthThree() )
		{
			ans = " an equilateral triangle";
			return ans;
		}
		else
		{
			return ans = " is neither a right or equilateral";
		}
	}
	
	
}

