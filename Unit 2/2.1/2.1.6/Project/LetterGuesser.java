import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LetterGuesser {

    public static ArrayList<String> setupLetters(ArrayList<String> array) {

        // setup the array with all letters
        array.addAll(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        return array;
    }

    public static ArrayList<String> updateLetters(String input, ArrayList<String> currentArray) {

        ArrayList<String> contained = new ArrayList<>();

        // repeat length of input
        for (int i = 0; i < input.length(); i++) {

            // get index letter
            String letter = String.valueOf(input.charAt(i)).toLowerCase();

            // check if the letter is possible prevent duplicate letters
            if (currentArray.contains(letter) && !contained.contains(letter)) {

                // if the letter is possible, add it to the new array
                contained.add(letter);
            }
        }

        return contained;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> letters = new ArrayList<String>();

        String letter = "";

        System.out.println("\nI will guess the letter you are thinking of.");

        // multiple games
        while (true) {

            setupLetters(letters);

            System.out.println("\nThink of a letter and press ENTER when ready.");
            sc.nextLine();

            // get 5 words
            for (int i = 0; i < 5; i++) {
                System.out.println("Enter a word that contains your letter.");
                String input = sc.nextLine();

                letters = updateLetters(input, letters);

                // if there is only one possible letter left, end the loop
                if (letters.size() == 1) {
                    letter = letters.get(0);
                    System.out.println("\nI got it!");
                    break;

                    // if there are somehow no possible letters, restart from the beginning
                } else if (letters.size() == 0) {
                    System.out.println("\nWhoops, something went wrong! Let's try that again...");
                    setupLetters(letters);
                    i = 0;
                }
            }

            // if it still doesnt know the letter, try each possible letter
            if (letter.equals("")) {

                System.out.println("\nHmm...");

                while (true) {

                    // get a random item from the possible letters
                    int random = (int) (Math.random() * letters.size());
                    String tryLetter = letters.get(random).toUpperCase();

                    System.out.println("Is your letter " + tryLetter + "? (Y/N)");

                    // ask the user if it was their letter
                    if (sc.nextLine().toLowerCase().equals("y")) {
                        System.out.println("\nI knew that all along!");
                        break;
                    } else {
                        letters.remove(random);
                        if (letters.size() == 0) {
                            System.out.println("\nI'm stumped!");
                            break;
                        }
                    }
                }

            }

            // if it DOES know the letter after the 5 words, say what it is
            else {
                System.out.println("Your letter is: " + letter.toUpperCase());
            }

            System.out.println("\nWould you like to play again? (Y/N)");

            // end loop if user doesnt say yes
            if (!(sc.nextLine().toLowerCase().equals("y"))) {
                break;
            }
        }

        System.out.println("\nThanks for playing!");
        sc.close();

    }
}