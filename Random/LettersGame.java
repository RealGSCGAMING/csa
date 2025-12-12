import java.util.Scanner;

public class LettersGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String[] letters = alphabet.split("");

        int score = 0;

        while (true) {
            int current = (int) (Math.random() * 26);

            System.out.println("Type the letter " + letters[current]);

            String input = sc.nextLine().toLowerCase();
            /*System.out.println(input);
            System.out.println(letters[current]);
            System.out.println(input.equals(letters[current]));*/


            if (input.equals(letters[current])) {
                score++;
                System.out.println("Score: " + score);
            }
            else {
                System.out.println("Fail");
                break;
            }
        }

        sc.close();
    }
}
