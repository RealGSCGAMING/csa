package NotWordle;

import java.io.*;
import java.util.*;

public class WordList {

    private String[] words = new String[5757];
    private String fileName = "Random\\words.txt";

    public WordList() {
        readFile();
    }

    public String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    private void readFile() {
        while (true) {
            try {
                File f = new File(fileName);
                Scanner fileScan = new Scanner(f);
                int i = 0;
                while (fileScan.hasNext()) {
                    words[i] = fileScan.nextLine();
                    i++;
                }
                fileScan.close();
                break;
            } catch (Exception e) {
                System.out.println("An error occured while reading the words file:\n" + e + "\nPress ENTER to try again.");
            }
        }
    }
}
