
/*
* Activity 2.1.1
*/
import java.util.Scanner;

public class GetDigits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a positive integer to see its digits: ");
    int number = sc.nextInt();

    /* your code here */
    int digits = 0;

    boolean cont = false;

    int tempnum = number;

    while (!cont) {
      tempnum /= 10;
      System.out.println(tempnum);
      digits++;
      if (tempnum <= 0) {
        cont = true;
      }
    }

    System.out.println("Digits:");

    for (int i = digits - 1; i >= 0; i--) {
      int place = (int) Math.pow(10, i);
      int digit = number / place;
      System.out.println(digit);
      number = number % place;
    }

    sc.close();

  }
}