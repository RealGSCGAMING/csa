/*
 * Activity 1.3.5
 */
import java.util.Scanner;

public class CompoundBoolean
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in); 
    
    System.out.println("Enter the first number");
    int a = sc.nextInt(); 
    System.out.println("Enter the second number");
    int b = sc.nextInt(); 
    System.out.println("Enter the third number");
    int c = sc.nextInt(); 
    
    /* your code here */
    if ((!(a > b) && (b > c))) {
        System.out.println("hi");
    }
  
    // close Scanner when done
    sc.close();
  }
}
