
public class Craps 
{
Die dieOne = new Die();
Die dieTwo = new Die();

 int Sum = dieOne.rollDie() + dieTwo.rollDie();

	public int Printer()
	{
   return Sum;
	}
}
