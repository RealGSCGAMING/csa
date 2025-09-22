/*
 * Activity 1.2.9
 */
import java.util.Scanner;

public class GetInput
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    
System.out.print("Enter a pet's name: ");
String petName = sc.nextLine();

System.out.print("Enter " + petName + "'s age: ");
double age = sc.nextDouble();


System.out.print("Enter " + petName + "'s weight: ");
int weight = sc.nextInt();

System.out.print("Enter " + petName + "'s new client status (true/false): ");
boolean isNew = sc.nextBoolean();

System.out.println("Hello " + petName);
System.out.println(petName + " is " + age + " year(s) old");
System.out.println(petName + " weighs " + weight + " lbs.");
System.out.println(petName + " is a new client: " + isNew);

sc.close();
  }
}