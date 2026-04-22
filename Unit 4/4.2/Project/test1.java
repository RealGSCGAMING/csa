import java.util.ArrayList;

public class test1 extends SortBase{


    public static ArrayList<Book> sort(ArrayList<Book> arr, int lt, int rt) {

        int m = lt + (rt - lt) / 2;
        
        //System.out.println("This is the size of the First Array: " + (m - lt + 1));

        if (arr.size() == 1) { // base case
            
        }
        else {
            int n1 = m - lt + 1;
            int n2 = rt - m;

            ArrayList<Book> left = new ArrayList<Book>(n1);
            ArrayList<Book> right = new ArrayList<Book>(n2);

            for(int i = 0; i < n1; i++){
                left.add(i, arr.get(i));
            }
            int newJ = 0;
            for(int j = arr.size() - n1; j < arr.size(); j++){
                right.add(newJ, arr.get(j));
                newJ++;
            }


        }

        return arr;
}
}