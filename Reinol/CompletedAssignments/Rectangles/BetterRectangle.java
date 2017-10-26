/*=======================================================================
|   Source code:  BetterRectangle.java
|
|              Class: [BetterRectangleTriangle.java] 
|
|           Author:  [Reinol Diaz]
|     Student ID:  [2923555]
|    Assignment:  Program #4 - Rectangles
|  
|            Course:  COP 3337 (Programming 2)
|           Section:  U01
|        Instructor:  William Feild  
|        Due Date:  10/26/2017, by the end of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Reinol Diaz]
|  
|        Language:  Java
|   Compile/Run:  [How to Compile and Execute this program, IN DETAIL.] 
| 	javac BRectTester.java  BetterRectangle.java
|	java BRectTester
|
|        Purpose:  [The Program will create a Better Rectangle sub-class
|					that extends the rectangle class and adds methods
|					and constructors]
|
|  Inherits From:  [Recthangle super class]
|
|     Interfaces:  [N/a]
|
| +-----------------------------------------------------------------------
|
|      Constants:  [None]
|					
|	   Equations:  [Area = Length * width
					Perimeter = 2*length + 2*width
					Slope = height/width
					Midpoint = x + width / 2  , y + height / 2
| +-----------------------------------------------------------------------
|
|   Constructors:  [Triangle - which takes in the 6 values of the points 
|                   and creates the triangle]
|
|  Class Methods:  [BetterRectangle()
|			BetterRectangle( int width,int height )]
|			BetterRectangle( int x , int y , int width , int height )
|			BetterRectangle( BetterRectangle r )
|			public String toString()
|			public boolean equals( BetterRectangle r )
|			public int getArea()
|			public int getPerimeter()
|			public float getSlope()
|			public Point getMidPoint()
|			public boolean congruent( BetterRectangle r )
|			public boolean equivalent( BetterRectangle r )
|			public boolean similar( BetterRectangle r )
|			public boolean concentric( BetterRectangle r )
|			public boolean scaleBy( int scale )
|	
|  Instance Methods:   [None]
|
|  *===========================================================================*/











import java.awt.*;

public class BetterRectangle extends Rectangle
{
	//the four types of possible BetterRectangles
	BetterRectangle()
	{
		Point p = new Point();
		super.setLocation( p );
		super.setSize( 1 , 1 );	
	}
	
	BetterRectangle( int width,int height )
	{
		Point p = new Point();
		super.setLocation( p );
		super.setSize( width , height );
	}
	
	BetterRectangle( int x , int y , int width , int height )
	{
		Point p = new Point( x , y );
		super.setLocation( p );
		super.setSize( width , height );
	}
	BetterRectangle( BetterRectangle r )
	{
		super.setLocation( r.getLocation() );
		super.setSize( r.getSize() );
	}
	
	//to string and equals methods
	
	 public String toString()
	 {
		return String.format( super.toString()+ "  Area : " + this.getArea() 
		+ "   Perimeter : "+ "" + this.getPerimeter() +  "   Slope : " +
		this.getSlope() + "   MidPoint : " + this.getMidPoint() ); 
	 }
	 
	 public boolean equals( BetterRectangle r )
	 {
		if( r != null )
		{
			if( this == r ) 
				{
				return true;
				}
			else return false; 
		}
		else return false;
	 }
	 
	 
	// Added accessors
	 
	 public int getArea()
	 {
		return this.width * this.height; 
	 }
	 
	 public int getPerimeter()
	 {
		return 2 * (this.width + this.height);
	 }
	 
	 public float getSlope()
	 {
		return height / (float)width;
	 }
	 public Point getMidPoint()
	 {
		Point midPoint = new Point( (int) (this.x + this.width / 2) ,
				(int) (this.y + this.height / 2) );
		return midPoint; 
	 }
	 
	 
	// Added utilities
	 
	 public boolean congruent( BetterRectangle r )
	 {
		if( r != null && ( this.width + this.height ) == (r.width + r.height ) ) 
			{
			return true;
			}
		else return false;
	 }
	 
	 public boolean equivalent( BetterRectangle r )
	 {
		if( r != null && this.getPerimeter() == r.getPerimeter() )
			{
			return true;
			}
		else return false; 
	 }
	 
	 public boolean similar( BetterRectangle r )
	 {
		if( r != null && this.getArea() == r.getArea() )
			{
			return true; 
			}
		else return false;
	 }
	 
	 public boolean concentric( BetterRectangle r )
	 {
		if( r != null && this.getMidPoint() == r.getMidPoint() )
			{
			return true;
			}
		else return false; 
	 }
	 
	// Added mutators
	 
	public boolean scaleBy( int scale )
	{
		if( scale > 0 )
		{
			this.height *= scale;
			this.width *= scale;
			return true;
		}
		else return false;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
