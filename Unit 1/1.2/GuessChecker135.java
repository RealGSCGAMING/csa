/*
 * Activity 1.3.2
 */
import java.util.Scanner;
 
public class GuessChecker135
{
  static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
    /* Add any variables you will need throughout the program here. */
    int hits = 0;
    int nearHits = 0;
    // Generate a random number
    int targetNumber = getRandomNumber();
    //System.out.println(targetNumber);  // uncomment for debugging
    
    // Break the random number into four variables.
    int r1 = targetNumber / 1000;
    int r2 = targetNumber / 100 % 10;
    int r3 = targetNumber / 10 % 10;
    int r4 = targetNumber % 10;
    
    // Get the user's guess
    int guess = getGuess();
    //System.out.println(guess);   // uncomment for debugging
    
    // Break the user's guess into four variables.
    int g1 = guess / 1000;
    int g2 = guess / 100 % 10;
    int g3 = guess / 10 % 10;
    int g4 = guess % 10;

    /*your code here*/
    if (r1 == g1) {
      hits++;
    }
    else if (r1 == g2 || r1 == g3 || r1 == g4) {
      nearHits++;
    }

    if (r2 == g2) {
      hits++;
    }
    else if (r2 == g1 || r2 == g3 || r2 == g4) {
      nearHits++;
    }

    if (r3 == g3) {
      hits++;
    }
    else if (r3 == g1 || r3 == g2 || r3 == g4) {
      nearHits++;
    }

    if (r4 == g4) {
      hits++;
    }
    else if (r4 == g1 || r4 == g2 || r4 == g3) {
      nearHits++;
    }

    System.out.println(hits + " correct digits in the right position");
    System.out.println(nearHits + " correct digits in the wrong position");
    // close Scanner when done
    sc.close();
	}
 
  // Checks to ensure no duplicate digits in a int.
	public static boolean hasDupes(int num)
	{ 
		boolean[] digs = new boolean[10];
		while (num > 0)
		{
			if (digs[num % 10])
			  return true;
			digs[num % 10] = true;
			num /= 10;
		}
		return false;
	}

  // Creates a new random 4 digit code 1000-9999 with no duplicates.
  public static int getRandomNumber() 
  { 
		int target = (int) (Math.random() * 9000 + 1000);
		while (hasDupes(target))
		  target = (int) (Math.random() * 9000 + 1000);
    return target;
  }

  // Prompts the user for a guess and repeats until valid guess is made.
  public static int getGuess()
  { 

    int userGuess = 0;
    boolean validGuess = false;
    
    while (!validGuess)
    {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      userGuess = sc.nextInt();
      if (!(hasDupes(userGuess) || (userGuess < 1000))) 
        validGuess = true;
    }
    return userGuess;
  }
}
