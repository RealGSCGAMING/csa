import java.util.ArrayList;

class SortBase {
    public static void load() {
        System.out.println();
    }
}

class SortSelection extends SortBase {
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
     * Performs an insertion sort on the ArrayList
     */
    public static ArrayList<Book> sort(ArrayList<Book> arr) {

        for (int i = 1; i < arr.size(); i++) {
            Book curr = arr.get(i);
            int marker = i - 1;

            while (marker >= 0) {
                if (curr.getTitle().compareTo(arr.get(marker).getTitle()) > 0) {
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
     * @param arr the ArrayList of Books to be merged
     * 
     * @param lt  the first index of arr
     * 
     * @param m   the midpoint index of arr
     * 
     * @param rt  the last index of arr
     * 
     * 
     */

    public static ArrayList<Book> sort(ArrayList<Book> arr, int lt, int m, int rt) {

        // Find sizes of two subararys to be merged
        int n1 = m - lt + 1;
        int n2 = rt - m;

        System.out.println(n1 + " " + n2);

        // Create temp arrays
        ArrayList<Book> left = new ArrayList<Book>(n1);
        ArrayList<Book> right = new ArrayList<Book>(n2);
        
        //System.out.println("test");
        System.out.println(left.size());
        System.out.println(right.size());
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left.set(i, arr.get(lt + i));
        }
        for (int j = 0; j < n2; j++) {
            right.set(j, arr.get(m + 1 + j));
        }

        System.out.println(left);
        System.out.println(right);

        // Merge the temp arrays

        // Initial indexes of first and second subararys
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int k = lt;
        while (i < n1 && j < n2) {
            if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) <= 0) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of AL<> L if any
        while (i < n1) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of AL<> R if any
        while (j < n2) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }

        return arr;

    }
}