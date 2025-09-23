/*
 * Activity 2.1.3
 */
import java.util.Scanner;

public class Dyslexia
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String input = sc.nextLine();
    String output = "";

    String letter;
    boolean yes;
    int nln;
    String newLetter;

    String[] letters = {"d", "b", "p", "q"};

    for (int i = 0; i < input.length(); i++) {

        letter = input.substring(i, i+1);

        yes = (letter.equals("d") || letter.equals("b") || letter.equals("p") || letter.equals("q"));
        
        if (yes) {
            nln = (int) (Math.random() * 3 + 1);
            newLetter = letters[nln];
            output = output + newLetter;
        }
        else {
            output = output + letter;
        }
    }

    System.out.println(output);
    sc.close();

  }
}