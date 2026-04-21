import java.util.ArrayList;

class SearchBase {
    public static void load() {
        System.out.println();
    }
}

class SearchLinear extends SearchBase {
    
    public static int search(ArrayList<Sentiment> arr, int rt, int lt, String x){

        for(int i = rt; i < lt + 1; i++){
            
            //if the String matches x, return index
            if(arr.get(i).getPhrase().equals(x))
                return i;
        }
        return -1;//otherwise, return -1


    }
}

class SearchBinaryIterative extends SearchBase {

    public static int search(ArrayList<Sentiment> arr, int lt, int rt, String x){

        //as long as the right index and left index have not gone past each other
        while(rt >= lt){
            int mid = lt + (rt - lt)/2;

            //if the String was found, return the index
            if(arr.get(mid).getPhrase().compareTo(x) == 0)
                return mid;
            
            //if the average was greater (alphabetically), loop over with the greater half discarded
            else if(arr.get(mid).getPhrase().compareTo(x) > 0)
                rt = mid - 1;
            
            //if the average was lesser (alphabetically), loop over with the lesser half discarded
            else
                lt = mid + 1;
        }
        return -1;//if nothing was found
    }
}

class SearchBinaryRecursive extends SearchBase {
    
    public static int search(ArrayList<Sentiment> arr, int lt, int rt, String x){
        
        //as long as the right index and left index have not gone past each other
        if(rt >= lt){
            int mid = lt + (rt - lt)/2;

            if(arr.get(mid).getPhrase().compareTo(x) == 0)//if the String was found, return the index
                return mid;
            
            else if(arr.get(mid).getPhrase().compareTo(x) > 0)//if the average was greater (alphabetically), call a search() with the greater half discarded
                SearchBinaryRecursive.search(arr, lt, mid - 1, x);

            else//if the average was less (alphabetically), call a search() with the lesser half discarded
                SearchBinaryRecursive.search(arr, mid+1, rt, x);
        }
        return -1;//if nothing was found
    }
}