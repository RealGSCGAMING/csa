
/*
 * Activity 4.2.2
 */
import java.util.ArrayList;

public class InsertionSort {
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
         */

        // CODE TO ADD
        for (int n = 0; n < 100; n++) {
            ratings.add((int) (Math.random() * 100));
        }

        int comparisons = 0;
        int modifications = 0;

        // the first element is sorted (so far) so iterate through all others
        for (int i = 1; i < ratings.size(); i++) {

            System.out.println("Current array: " + ratings);
            System.out.println("Checking index " + i + " (" + ratings.get(i) + ")");

            // save curr element
            int curr = ratings.get(i);

            // store the last element of the sorted portion,
            // the remaining portion is unsorted
            int marker = i - 1;

            // loop backwards through the sorted portion starting at marker
            while (marker >= 0) {
                comparisons++;
                if ((curr < ratings.get(marker))) {
                    modifications++;
                    System.out.println(
                            "Swapping index " + i + " (" + ratings.get(i) + ") and " + marker + " ("
                                    + ratings.get(marker) + ")");
                    ratings.set(marker + 1, ratings.get(marker));
                    ratings.set(marker, curr);
                } else {
                    // element is in correct place so stop iterating
                    marker = -1;
                    System.out.println("Stopping");
                }
                marker--;
                if (marker == -1) {
                    System.out.println("Reached end of array");
                }
            }

            System.out.println();
        }

        System.out.println(ratings);
        System.out.println("Comparisons: " + comparisons + ", Modifications: " + modifications);
    }
}
