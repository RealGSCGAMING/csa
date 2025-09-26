import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();

  static {
    try {
      Scanner input = new Scanner(new File(
          "C:\\Users\\1961680\\Desktop\\CSA\\Unit 2\\2.1\\2.1.6\\CSA_216_ConsumerLab_Starter\\ConsumerLab_Code\\cleanSentiment.csv"));
      while (input.hasNextLine()) {
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0], Double.parseDouble(temp[1]));
        // System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    } catch (Exception e) {
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }

    // read in the positive adjectives in postiveAdjectives.txt
    try {
      Scanner input = new Scanner(new File(
          "C:\\Users\\1961680\\Desktop\\CSA\\Unit 2\\2.1\\2.1.6\\CSA_216_ConsumerLab_Starter\\ConsumerLab_Code\\positiveAdjectives.txt"));
      while (input.hasNextLine()) {
        posAdjectives.add(input.nextLine().trim());
      }
      input.close();
    } catch (Exception e) {
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

    // read in the negative adjectives in negativeAdjectives.txt
    try {
      Scanner input = new Scanner(new File(
          "C:\\Users\\1961680\\Desktop\\CSA\\Unit 2\\2.1\\2.1.6\\CSA_216_ConsumerLab_Starter\\ConsumerLab_Code\\negativeAdjectives.txt"));
      while (input.hasNextLine()) {
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    } catch (Exception e) {
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including
   * punctuation),
   * with words separated by a single space
   */
  public static String textToString(String fileName) {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      // add 'words' in the file to the string, separated by a single space
      while (input.hasNext()) {
        temp = temp + input.next() + " ";
      }
      input.close();

    } catch (Exception e) {
      System.out.println("Unable to locate " + fileName);
    }
    // remove any additional space that may have been added at the end of the string
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative)
   *          to 1 (very positive sentiment)
   */
  public static double sentimentVal(String word) {
    try {
      return sentiment.get(word.toLowerCase());
    } catch (Exception e) {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is
   * none
   */
  public static String getPunctuation(String word) {
    String punc = "";
    for (int i = word.length() - 1; i >= 0; i--) {
      if (!Character.isLetterOrDigit(word.charAt(i))) {
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

  /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation(String word) {
    while (word.length() > 0 && !Character.isAlphabetic(word.charAt(0))) {
      word = word.substring(1);
    }
    while (word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length() - 1))) {
      word = word.substring(0, word.length() - 1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and
   * returns it.
   */
  public static String randomPositiveAdj() {
    int index = (int) (Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and
   * returns it.
   */
  public static String randomNegativeAdj() {
    int index = (int) (Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective() {
    boolean positive = Math.random() < .5;
    if (positive) {
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  public static double totalSentiment(String fileName) {
    String s = textToString(fileName);

    boolean done = false;
    double totalSentiment = 0.0;

    while (!done) {

      // find the next word to process
      int split = s.indexOf(" ", 1);

      // if last word, move split to end of word
      if (split == -1) {
        split = s.length();
      }

      // isolate the word
      String word = s.substring(0, split);
      word = removePunctuation(word);
      System.out.println(word);

      double sentiment = sentimentVal(word);
      System.out.println(sentiment);

      // increment total
      totalSentiment += sentiment;

      if (s.length() <= 0) {
        done = true;
      } else {

        // remove word from string
        s = s.substring(split);

      }

    }

    // round sentiment to nearest hundredth
    return Math.round(totalSentiment * 100.00) / 100.00;
  }

  public static int starRating(String fileName) {

    double sentiment = totalSentiment(fileName);
    if (sentiment > 15) {
      return 5;
    } else if (sentiment > 10) {
      return 4;
    } else if (sentiment > 5) {
      return 3;
    } else if (sentiment > 0) {
      return 2;
    } else {
      return 1;
    }

  }

  public static String fakeReview(String fileName) {

    String s = textToString(fileName);

    while (true) {
      int start = s.indexOf("*") + 1;
      if (start == 0) {
        break;
      }

      int end = s.indexOf(" ", start);
      if (end == -1) {
        end = s.length();
      }

      String word = s.substring(start, end);
      word = removePunctuation(word);

      System.out.println(word);

      double sentiment = sentimentVal(word);

      System.out.println(sentiment);

      boolean valid = false;

      while (!valid) {
        if (sentiment >= 0) {
          word = randomPositiveAdj();
        } else {
          word = randomNegativeAdj();
        }

        word = word.substring(0, word.indexOf(","));

        if (sentimentVal(word) <= -2 || sentimentVal(word) >= 2) {
          valid = true;
        }
      }

      s = s.substring(0, start - 1) + word + s.substring(end);

    }
    return s;
  }

}