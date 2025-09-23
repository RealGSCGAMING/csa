/*
 * Activity 2.1.1
 */
import java.util.Scanner;

public class Divisibility
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the dividend: ");
    int dividend = sc.nextInt();
    System.out.println("Enter the divisor: ");
    int divisor = sc.nextInt();
    
    int num = dividend;
    
    boolean cont = false;
    boolean div = false;

    /* your code here */
      while (!cont) {
        num -= divisor;
        if (num == 0) {
          div = true;
          cont = true;
        }
        else if (num < 0) {
          div = false;
          cont = true;
        }
      }
      
      if (div) {
        System.out.println("divisible");
      }
      else {
        System.out.println("Not divisible");
      }

      sc.close();
  }
}