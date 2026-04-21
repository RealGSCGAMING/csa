
/*
 * Project 4.1.5
 */
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class SearchAndSortAnalysis {
  public static void main(String[] args) throws FileNotFoundException {
    // In your new class(es), write a class method called load
    // that contains a single println statement.
    // Call the load method, replacing YourClass with your actual class name:
    // YourClass.load();

    SortSelection.load();
    SortInsertion.load();
    SortMerge.load();
    SearchLinear.load();
    SearchBinaryIterative.load();
    SearchBinaryRecursive.load();

    /*
     * recall the algorithm to measure execution time
     * double startTime = System.nanoTime();
     * your code here
     * double execTime = (System.nanoTime() - startTime) / 1e9;
     */

    System.out.println("Running Selection Sort:");
    double startTime = System.nanoTime();
    ArrayList<Book> sorted = SortSelection.sort(Data.getBooks());
    double execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Done in " + execTime + "s\n");

    System.out.println("Running Insertion Sort:");
    double startTime2 = System.nanoTime();
    ArrayList<Book> sorted2 = SortInsertion.sort(Data.getBooks());
    double execTime2 = (System.nanoTime() - startTime2) / 1e9;
    System.out.println("Done in " + execTime2 + "s\n");

    System.out.println("Running Merge Sort:");
    int min = 0, max = Data.getBooks().size() - 1, mid = (int) ((double) (Data.getBooks().size() - 1) / 2);
    System.out.println(min + " " + mid + " " + max);
    double startTime3 = System.nanoTime();
    ArrayList<Book> sorted3 = SortMerge.sort(Data.getBooks(), min, mid, max - 1);
    double execTime3 = (System.nanoTime() - startTime3) / 1e9;
    System.out.println("Done in " + execTime3 + "s\n");

    /*System.out.println("Running Linear Search:");
    double startTime4 = System.nanoTime();
    ArrayList<Book> sorted4 = SortSelection.sort(Data.getBooks());
    double execTime4 = (System.nanoTime() - startTime4) / 1e9;
    System.out.println("Done in " + execTime4 + "s\n");*/
  }
}