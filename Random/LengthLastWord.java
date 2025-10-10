import java.util.Scanner;

public class LengthLastWord {

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println("Enter your string");
        Scanner sc = new Scanner(System.in);
        System.out.println("The length of the last word in your string is " + lengthOfLastWord(sc.nextLine()));
        sc.close();
    }

}
