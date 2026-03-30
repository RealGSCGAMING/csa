// Not part of PLTW

import java.io.File;
import java.util.Scanner;

// Shakespeare Play Generator!!!!!!!!!1!1
public class Shakespeare {

    static String[] characters = {
            "Hamlet",
            "Romeo",
            "Juliet",
            "King",
            "Omelet",
            "Shakespeare",
            "John Smith",
            "Mr Couvrette"
    };

    static String[] lines = new String[100];

    public static void main(String[] args) {
        // Load the file
        File linesFile = new File("4.1\\PhraseData\\shakespearean.txt");
        loadFile(linesFile);
        if (lines[0] == null) return;

        System.out.print("\033\143");

        // Introduce the play
        String playName = getRandomWord() + getRandomWord();
        System.out.println("--- Now Presenting ---");
        System.out.println("Shakespeare's \"" + capitalize(playName) + "\"");

        // Introduce characters
        int[] chars = new int[3];
        while (chars[0] == chars[1] || chars[1] == chars[2] || chars[2] == chars[0]) {
            chars[0] = (int) (Math.random() * characters.length);
            chars[1] = (int) (Math.random() * characters.length);
            chars[2] = (int) (Math.random() * characters.length);
        }
        System.out.println("\nFeaturing: ");
        System.out.println(characters[chars[0]]);
        System.out.println(characters[chars[1]]);
        System.out.println(characters[chars[2]]);

        // Play

        System.out.println("\n--- ACT ONE ---\n");
        
        for (int i = 0; i < 20; i++) {
            System.out.println(generateLine(chars[i % 3]));
        }

        System.out.println("\n--- THE END ---\n");
    }

    static String generateLine(int character) {
        String line = characters[character];
        String say = lines[(int) (Math.random() * 100)];
        line += ": " + capitalize(say.substring(4));
        return line;
    }

    static String getRandomWord() {
        String sentence = lines[(int) (Math.random() * 100)].substring(4);
        String[] words = sentence.split(" ");
        String word = words[(int) (Math.random() * words.length)];
        return word;
    }

    static String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    static void loadFile(File file) {
        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; i < 100; i++) {
                lines[i] = sc.nextLine();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Could not load the file");
        }
    }
}
