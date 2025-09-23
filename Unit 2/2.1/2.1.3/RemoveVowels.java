/*
 * Activity 2.1.3
 */
import java.util.Scanner;

public class RemoveVowels
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String input = sc.nextLine();
    String output = "";

    String letter;
    boolean yes;

    for (int i = 0; i < input.length(); i++) {

        letter = input.substring(i, i+1);

        System.out.println(letter);

        yes = !(letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u"));

        System.out.println(yes);

        if (yes) {
            output = output + input.charAt(i);
        }
    }

    System.out.println(output);
    sc.close();
  }
}