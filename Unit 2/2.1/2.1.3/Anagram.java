
/*
 * Activity 2.1.3
 */
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String: ");
        String input1 = sc.nextLine().toLowerCase();

        System.out.println("Enter another String: ");
        String input2 = sc.nextLine().toLowerCase();

        String letter1;
        String letter2;
        boolean equal;
        boolean anagram = false;

        int i = 0;

        if (input1.length() == input2.length()) {

            while (i < input1.length()) {

                equal = false;

                letter1 = input1.substring(i, i + 1);

                for (int i2 = 0; i2 < input2.length(); i2++) {

                    letter2 = input2.substring(i2, i2 + 1);

                    if (letter1.equals(letter2)) {

                        equal = true;
                        input1 = input1.substring(0, i) + input1.substring(i + 1);
                        input2 = input2.substring(0, i2) + input2.substring(i2 + 1);
                        break;
                        
                    }
                }

                if (!equal) {
                    break;
                }

                if (input1.length() == 0) {
                    anagram = true;
                }
            }
        }

        if (!anagram) {
            System.out.println("These strings are NOT anagrams");
        } else {
            System.out.println("These strings are anagrams");
        }

        sc.close();

    }
}