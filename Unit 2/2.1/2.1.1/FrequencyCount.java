/*
 * Activity 2.1.1
 */
import java.util.Scanner;

public class FrequencyCount
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    // choose something to count in place of ...
    System.out.println("Enter a sentence and I will count spaces "); 
    String str = sc.nextLine();

    /* your code here */
    int count = 0;
    boolean cont = false;
    int index = 0;

    while (!cont) {

        index = str.indexOf(" ", index + 1);

        if (index > 0) {
            count++;
        }
        else {
            cont = true;
        }
    }

    System.out.println(count);
    sc.close();
  }
}