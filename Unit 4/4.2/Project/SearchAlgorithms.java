import java.util.ArrayList;

class SearchBase {

    /**
     * Preloads the class.
     */
    public static void load() {
        System.out.println();
    }
}

class SearchLinear extends SearchBase {

    /**
     * Performs a Linear Search on an ArrayList of Sentiments.
     * 
     * @param arr The ArrayList to be searched
     * 
     * @param lt  The first index to search
     * 
     * @param rt  The last index to search
     * 
     * @param x   The String to search for
     * 
     * @return The index of the found element, or -1 if not found
     */
    public static int search(ArrayList<Sentiment> arr, int lt, int rt, String x) {

        for (int i = lt; i < rt + 1; i++) {

            // if the String matches x, return index
            if (arr.get(i).getPhrase().equals(x))
                return i;
        }
        return -1;// otherwise, return -1

    }
}

class SearchBinaryIterative extends SearchBase {

    /**
     * Performs an Iterative Binary Search on an ArrayList of Sentiments.
     * 
     * Precondition: arr must be sorted in alphabetical order by the phrase field of
     * Sentiment
     * 
     * @param arr The ArrayList to be searched
     * 
     * @param lt  The first index to search
     * 
     * @param rt  The last index to search
     * 
     * @param x   The String to search for
     * 
     * @return The index of the found element, or -1 if not found
     */
    public static int search(ArrayList<Sentiment> arr, int lt, int rt, String x) {

        // as long as the right index and left index have not gone past each other
        while (rt >= lt) {
            int mid = lt + (rt - lt) / 2;

            // if the String was found, return the index
            if (arr.get(mid).getPhrase().compareTo(x) == 0)
                return mid;

            // if the average was greater (alphabetically), loop over with the greater half
            // discarded
            else if (arr.get(mid).getPhrase().compareTo(x) > 0) 
                rt = mid - 1;
            

            // if the average was lesser (alphabetically), loop over with the lesser half
            // discarded
            else
                lt = mid + 1;
            
        }
        return -1;// if nothing was found
    }
}

class SearchBinaryRecursive extends SearchBase {

    /**
     * Performs a Recursive Binary Search on an ArrayList of Sentiments.
     * 
     * Precondition: arr must be sorted in alphabetical order by the phrase field of
     * Sentiment
     * 
     * @param arr The ArrayList to be searched
     * 
     * @param lt  The first index to search
     * 
     * @param rt  The last index to search
     * 
     * @param x   The String to search for
     * 
     * @return The index of the found element, or -1 if not found
     */
    public static int search(ArrayList<Sentiment> arr, int lt, int rt, String x) {

        // as long as the right index and left index have not gone past each other
        if (rt >= lt) {
            int mid = lt + (rt - lt) / 2;

            if (arr.get(mid).getPhrase().compareTo(x) == 0) 
                return mid;
            

            else if (arr.get(mid).getPhrase().compareTo(x) > 0) 
                // if the average was greater (alphabetically), call a
                // search() with the greater half discarded
                return SearchBinaryRecursive.search(arr, lt, mid - 1, x);
            

            else // if the average was less (alphabetically), call a search() with the lesser
                  // half discarded
                return SearchBinaryRecursive.search(arr, mid + 1, rt, x);
            
        } 
        
        return -1; // if nothing was found
        
    }
}