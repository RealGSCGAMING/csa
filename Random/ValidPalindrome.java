import java.util.Scanner;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        // this is probably the worst possible way to remove the punctuation
        s = s.toLowerCase();

        // letters list which also includes numbers
        String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

        String newString = "";

        for (int i = 0; i < s.length(); i++) {

            // convert the char value of the character at index i to a string value but only if it's a letter
            if (letters.contains(String.valueOf(s.charAt(i)))) {

                // add the converted string value to the new string
                newString += String.valueOf(s.charAt(i));
            }
        }

        s = newString;

        for (int i = 0; i < s.length() / 2; i++) {

            if (!(s.charAt(i) == s.charAt(s.length() - i - 1))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word to check.");
        String word = sc.nextLine();

        boolean is = isPalindrome(word);

        if (is) {
            System.out.println(word + " is a palindrome!");
        }
        else {
            System.out.println(word + " is NOT a palindrome!");
        }

        sc.close();
    }

}