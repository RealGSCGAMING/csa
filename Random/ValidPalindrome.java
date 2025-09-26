import java.util.Scanner;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        String letters = "abcdefghijklmnopqrstuvwxyz1234567890";
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            if (letters.contains(String.valueOf(s.charAt(i)))) {
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