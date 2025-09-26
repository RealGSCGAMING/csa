import java.util.Scanner;
import java.util.ArrayList;

public class LetterGuesser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nI will guess the letter you are thinking of.");

        while (true) {
            System.out.println("Think of a letter and press ENTER when ready.");
            sc.nextLine();

            while (true) {
                System.out.println("Enter a word that contains your letter.");
                String input = sc.nextLine();
            }
        }
        
    }
}