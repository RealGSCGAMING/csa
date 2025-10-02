/*
 * Activity 2.2.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points; 
  Scanner sc = new Scanner(System.in);
  /* your code here - constructor(s) */ 

  public Player() {

    points = 0;

    System.out.println("Enter your name.");
    setName(sc.nextLine());
    System.out.println("Welcome, " + name + "!");
  }

  public Player(String inputName) {
    points = 0;

    setName(inputName);
    System.out.println("Welcome, " + name + "!");
  }
  
  /* your code here - accessor(s) */ 
  public int getPoints() {
    return 1;
  }

  public String getName() {
    return "hi";
  }
  /* your code here - mutator(s) */ 
  public void setPoints(int pts) {

  }

  public void setName(String newName) {
    name = newName;
  }
}