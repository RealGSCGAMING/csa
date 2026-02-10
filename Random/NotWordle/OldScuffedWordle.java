package NotWordle;
import java.io.*;
import java.util.Scanner;

public class OldScuffedWordle {

    static String[] words = new String[5757];

    private static void loadWords() throws IOException {
        File f = new File("Random\\words.txt");
        Scanner fileScan = new Scanner(f);
        int i = 0;
        while (fileScan.hasNext()) {
            words[i] = fileScan.nextLine();
            i++;
        }
        fileScan.close();
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            loadWords();
            clearConsole();
        } catch (Exception e) {
            System.out.println("An error occured when loading the words.");
            System.out.println(e);
            return;
        }

        System.out.println("Welcome to Wordle! Try to guess the 5 letter word. Type 'q' to quit.");
        System.out.println("[G] = correct letter in correct place");
        System.out.println("[?] = correct letter in wrong place");
        System.out.println("[X] = incorrect letter");

        int round = 1;

        while (true) {
            System.out.println("Round " + round);
            int random = (int) (Math.random() * words.length);
            String word = words[random];
            String[] wordArray = word.split("");
            // System.out.println(word);
            // System.out.println(Arrays.toString(wordArray));
            boolean quit = false;

            while (true) {
                String input = getInput();

                if (input.equals("quit")) {
                    quit = true;
                    break;
                }

                String[] inputArray = input.split("");
                String outputString = "";

                for (int i = 0; i < 5; i++) {
                    if (wordArray[i].equals(inputArray[i])) {
                        outputString += "[G]";
                    } else {
                        boolean in = false;
                        for (int j = 0; j < 5; j++) {
                            if (wordArray[j].equals(inputArray[i]) && j != i) {
                                in = true;
                            }
                        }

                        if (in) {
                            outputString += "[?]";
                        } else {
                            outputString += "[X]";
                        }
                    }
                }

                System.out.println(outputString);

                if (input.equals(word)) {
                    System.out.println("You did it!");
                    System.out.println("Press enter to play again.");
                    sc.nextLine();
                    break;
                }
            }

            if (quit)
                break;

        }

        round++;

        System.out.println("Thanks for playing!");
        sc.close();
    }

    static boolean itemInWords(String item) {
        for (String w : words) {
            if (w.equals(item)) {
                return true;
            }
        }
        return false;
    }

    static String getInput() {
        while (true) {
            String input = sc.nextLine().toLowerCase();
            if (input.equals("quit")) {
                return "quit";
            }

            else if (input.length() == 5) {
                if (itemInWords(input)) {
                    return input;
                } else {
                    System.out.println("Word is not in the word list");
                }
            } else {
                System.out.println("Please enter a 5 letter word");
            }
        }
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }
}
