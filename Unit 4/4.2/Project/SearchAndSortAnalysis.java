
/*
 * Project 4.1.5
 */
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Arrays;

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

    //SELECTION SORT
    System.out.println("Running Selection Sort:");
    double startTime = System.nanoTime();
    ArrayList<Book> sorted = SortSelection.sort(Data.getBooks());
    double execTime = (System.nanoTime() - startTime) / 1e9;//final time
    System.out.println("Done in " + execTime + "s");
    System.out.println(Data.scan(sorted) ? "Correctly sorted" : "Incorrectly sorted");//checking to make sure it was correctly sorted
    System.out.println();

    //INSERTION SORT
    System.out.println("Running Insertion Sort:");
    double startTime2 = System.nanoTime();
    ArrayList<Book> sorted2 = SortInsertion.sort(Data.getBooks());
    double execTime2 = (System.nanoTime() - startTime2) / 1e9;//final time
    System.out.println("Done in " + execTime2 + "s");
    System.out.println(Data.scan(sorted2) ? "Correctly sorted" : "Incorrectly sorted");//checking to make sure it was correctly sorted
    System.out.println();

    //MERGE SORT
    System.out.println("Running Merge Sort:");
    int min = 0, max = Data.getBooks().size() - 1;
    double startTime3 = System.nanoTime();
    ArrayList<Book> sorted3 = SortMerge.sort(Data.getBooks(), min, max);
    double execTime3 = (System.nanoTime() - startTime3) / 1e9;//final time
    System.out.println("Done in " + execTime3 + "s");
    System.out.println(Data.scan(sorted3) ? "Correctly sorted" : "Incorrectly sorted");//checking to make sure it was correctly sorted
    System.out.println();

    //The word that is needed to be found in the sentiments.csv
    String sentimentToFind = ((int) (Math.random() * 3) == 0 ? (Data.getSentiments().get((int) (Math.random() * Data.getSentiments().size())).getPhrase()) : "Fake Sentiment");

    //LINEAR SEARCH
    System.out.println("Running Linear Search:");
    double startTime4 = System.nanoTime();
    int index = SearchLinear.search(Data.getSentiments(), 0, Data.getSentiments().size()-1, sentimentToFind);//Running the linear class
    double execTime4 = (System.nanoTime() - startTime4) / 1e9;//final time
    System.out.println("Done in " + execTime4 + "s");
    System.out.println(index != -1 ? "Found " + sentimentToFind + " at index " + index : sentimentToFind + " not found");//checking to make sure it was found
    System.out.println();

    //BINARY ITERATIVE SEARCH
    System.out.println("Running Binary Iterative Search:");
    double startTime5 = System.nanoTime();
    int index2 = SearchBinaryIterative.search(Data.getSentiments(), 0, Data.getSentiments().size()-1, sentimentToFind);//Running the binary iterative class
    double execTime5 = (System.nanoTime() - startTime5) / 1e9;//final time
    System.out.println("Done in " + execTime5 + "s");
    System.out.println(index2 != -1 ? "Found " + sentimentToFind + " at index " + index2 : sentimentToFind + " not found");//checking to make sure it was found
    System.out.println();

    //BINARY RECURSIVE SEARCH
    System.out.println("Running Binary Recursive Search:");
    double startTime6 = System.nanoTime();
    int index3 = SearchBinaryRecursive.search(Data.getSentiments(), 0, Data.getSentiments().size()-1, sentimentToFind);//Running the binary recursive class
    double execTime6 = (System.nanoTime() - startTime6) / 1e9;//final time
    System.out.println("Done in " + execTime6 + "s");
    System.out.println(index3 != -1 ? "Found " + sentimentToFind + " at index " + index3 : sentimentToFind + " not found");//checking to make sure it was found
    System.out.println();


    // Analysis of the tests
    String fastestSort = "";
    double fastestSortTime = 0.0;
    if (execTime < execTime2 && execTime < execTime3) {
      fastestSort = "Selection Sort";
      fastestSortTime = execTime;
    } else if (execTime2 < execTime && execTime2 < execTime3) {
      fastestSort = "Insertion Sort";
      fastestSortTime = execTime2;
    } else {
      fastestSort = "Merge Sort";
      fastestSortTime = execTime3;
    }

    String fastestSearch = "";
    double fastestSearchTime = 0.0;
    if (execTime4 < execTime5 && execTime4 < execTime6) {
      fastestSearch = "Linear Search";
      fastestSearchTime = execTime4;
    } else if (execTime5 < execTime4 && execTime5 < execTime6) {
      fastestSearch = "Iterative Binary Search";
      fastestSearchTime = execTime5;
    } else {
      fastestSearch = "Recursive Binary Search";
      fastestSearchTime = execTime6;
    }

    System.out.println(fastestSort + " was the fastest sorting algorithm at " + fastestSortTime + " seconds.");
    System.out.println(fastestSearch + " was the faastest searching algorithm at " + fastestSearchTime + " seconds.");
    System.out.println("The total execution time of all algorithms was " + (execTime + execTime2 + execTime3 + execTime4 + execTime5 + execTime6) + " seconds.");
  }
}