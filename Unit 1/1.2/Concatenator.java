/*
 * Activity 1.2.7
 */
public class Concatenator
{
  public static void main(String[] args) {

    String string1 = "This is a very long string.";
    String string2 = "short string";

    System.out.println(string1);
    System.out.println(string2);

    String half1 = string1.substring(string1.length() / 2);
    String half2 = string2.substring(string2.length() / 2);

    System.out.println(half1);
    System.out.println(half2);

    String combinedString = half1 + half2;

    System.out.println(combinedString);

  }
  
}