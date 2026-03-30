
/*
 * Activity 4.1.1
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhraseData {
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File("4.1\\PhraseData\\phrases.txt"));

    /*
     * while (sc.hasNext()) {
     * System.out.println(sc.nextLine());
     * }
     */

    ArrayList<String> uniqueWords = new ArrayList<String>();
    String tempWord;

    while (sc.hasNext()) {
      tempWord = sc.next();
      boolean unique = true;
      for (String w : uniqueWords) {
        if (tempWord.equals(w)) {
          unique = false;
          break;
        }
      }
      if (unique) {
        uniqueWords.add(tempWord);
      }
    }

    sc.close();

    for (String w : uniqueWords) {
      System.out.println(w);
    }
  }
}
