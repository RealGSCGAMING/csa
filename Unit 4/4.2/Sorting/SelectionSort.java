
/*
 * Activity 4.2.2
 */
import java.util.ArrayList;

public class SelectionSort {
  public static void main(String[] args) {
    ArrayList<Integer> ratings = new ArrayList<Integer>();
    /*
     * ratings.add(5);
     * ratings.add(4);
     * ratings.add(8);
     * ratings.add(9);
     * ratings.add(2);
     * ratings.add(3);
     * ratings.add(1);
     * ratings.add(4);
     */

    // CODE TO ADD
    for (int n = 0; n < 100; n++) {
      ratings.add((int) (Math.random() * 100));
    }

    int comparisons = 0;
    int modifications = 0;

    // iterate through all elements except the last
    for (int i = 0; i < ratings.size() - 1; i++) {

      System.out.println("Current array: " + ratings);

      System.out.println("Checking index " + i + " (" + ratings.get(i) + ")");
      // keeps track of index with smallest value
      int minIndex = i;

      // starting at next element, find min value in the list
      for (int j = i + 1; j < ratings.size(); j++) {
        // if current value is smaller than the one at minindex,
        // set minIndex to current index
        comparisons++;
        if (ratings.get(j) < ratings.get(minIndex)) {
          minIndex = j;
        }
      }
      // swap elements if different
      comparisons++;
      if (ratings.get(i) != ratings.get(minIndex)) {
        modifications++;
        System.out.println(
            "Swapping index " + i + " (" + ratings.get(i) + ") and " + minIndex + " (" + ratings.get(minIndex) + ")");
        int tmp = ratings.get(i);
        ratings.set(i, ratings.get(minIndex));
        ratings.set(minIndex, tmp);
      } else {
        System.out.println("Not doing anything");
      }

      System.out.println();
    }

    System.out.println(ratings);
    System.out.println("Comparisons: " + comparisons + ", Modifications: " + modifications);

  }
}
