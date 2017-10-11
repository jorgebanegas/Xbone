public class Die
{
  private int face = 1;
  private int sides = 6;
  
  // Get current value
  public int getRoll ()  {
    return face;
  }

  //Roll the die, return new value
  public int rollDie ()  
  {
    face = (int)(Math.random()* sides + 1);
    return face;
  }

}
