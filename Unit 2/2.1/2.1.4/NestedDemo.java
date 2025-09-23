/*
 * Activity 2.1.4
 */
import java.util.Scanner;

public class NestedDemo
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a word");

    while (true)
    {

        String str = sc.nextLine();
    if (str.equals("q")) {
        break;
    }
      int end = str.length() - 1;
      boolean criteria = true;

      for (int start = 0; start <= end; start++)
      {
        if(!str.substring(start, start +1).equals(str.substring(end, end+1)))
        {
          criteria = false;
        }
        end--;
      }

      if (criteria)
        System.out.println("\"" + str + "\" meets the criteria ");
      else
        System.out.println("\"" + str + "\" does not meet the criteria");
          
      System.out.println("Enter a word or q to quit");
      criteria = true;

    }

    sc.close();
  }
}