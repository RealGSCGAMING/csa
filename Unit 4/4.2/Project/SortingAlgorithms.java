import java.util.ArrayList;

class SortBase {
    /**
     * Preloads the class.
     */
    public static void load() {
        System.out.println();
    }

}

class SortSelection extends SortBase {

    /**
     * Performs a Selection Sort on an ArrayList of Books.
     * 
     * @param arr The ArrayList to be sorted
     * 
     * @return The sorted ArrayList of Books
     */
    public static ArrayList<Book> sort(ArrayList<Book> arr) {

        // Repeat for every item in the array
        for (int i = 0; i < arr.size() - 1; i++) {

            // Set the beginning of the unsorted section
            int minIndex = i;

            // Find the smallest element in the unsorted section
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).getTitle().compareTo(arr.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }

            // Swap it with the first element in the unsorted section
            if (arr.get(i) != arr.get(minIndex)) {
                Book temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }

        return arr;
    }
}

class SortInsertion extends SortBase {

    /**
     * Performs an Insertion Sort on an ArrayList of Books.
     * 
     * @param arr The ArrayList to be sorted
     * 
     * @return The sorted ArrayList of Books
     */
    public static ArrayList<Book> sort(ArrayList<Book> arr) {

        for (int i = 1; i < arr.size(); i++) {
            Book curr = arr.get(i);
            int marker = i - 1;

            while (marker >= 0) {
                if (curr.getTitle().compareTo(arr.get(marker).getTitle()) < 0) {
                    arr.set(marker + 1, arr.get(marker));
                    arr.set(marker, curr);
                } else {
                    marker = -1;
                }

                marker--;
            }
        }
        return arr;
    }
}

class SortMerge extends SortBase {

    /**
     * Performs a Merge Sort on an ArrayList of Books.
     * 
     * @param arr The ArrayList to be sorted
     * 
     * @param lt  The first index of arr
     * 
     * @param m   The midpoint of arr
     * 
     * @param rt  The last index of arr
     * 
     * @return The sorted ArrayList of Books
     */
    public static ArrayList<Book> sort(ArrayList<Book> arr, int lt, int rt) {

        int m = (lt + rt) / 2;//the middle index of the ArrayList arr

        if (lt < rt) {
            sort(arr, lt, m);//Sorting the first half of the ArrayList
            sort(arr, m + 1, rt);//Sorting the second half of the ArrayList

            //find sizes of two subararys to be merged
            int n1 = m - lt + 1;
            int n2 = rt - m;

            ArrayList<Book> left = new ArrayList<Book>();//the split arrayList on the left side
            ArrayList<Book> right = new ArrayList<Book>();//the split arraylist on the right side

            //copying all information from ArrayList arr to these left and right ArrayLists
            for (int i = 0; i < n1; ++i) {
                left.add(arr.get(lt + i));
            }
            for (int j = 0; j < n2; ++j) {
                right.add(arr.get(m + 1 + j));
            }

            //merge the temp arrays

            //initial indices of first and second subarrays
            int i = 0;
            int j = 0;
            int k = lt;
            while (i < n1 && j < n2) {
                if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) < 0) {
                    arr.set(k, left.get(i));
                    i++;
                } else {
                    arr.set(k, right.get(j));
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr.set(k, left.get(i));
                i++;
                k++;
            }

            while (j < n2) {
                arr.set(k, right.get(j));
                j++;
                k++;
            }
        }

        return arr;
    }
}