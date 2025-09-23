/*
* Activity 2.1.1
*/
 import java.util.Scanner;

 public class GetDigits
 {
   public static void main(String[] args)
   {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a positive integer to see its digits: ");
     int number = sc.nextInt();

     /* your code here */

     int digit = 0;
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

     // i lowkey have no clue how to finish this

     // delete
     System.out.println(digits);
     System.out.println(digit);
     sc.close();
     
   }
 }