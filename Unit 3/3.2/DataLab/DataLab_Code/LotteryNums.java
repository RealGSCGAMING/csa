import java.util.ArrayList;
import core.data.*;

public class LotteryNums {
    public static void main(String[] args) {
        System.out.println("Loading data set... (This may take a while)");
        

        // Create a map of each number and its occurrences
        int[][] numbers = new int[69][2];
        for (int i = 0; i < 69; i++) {
            numbers[i][0] = i + 1;
            numbers[i][1] = 0;
        }

        // Load the data set
        DataSource ds = DataSource.connect("https://data.ny.gov/api/views/d6yy-54nr/rows.xml");
        ds.setCacheTimeout(15 * 60);
        ds.load();
        ArrayList<Drawing> drawings = ds.fetchList("Drawing", "row/row/winning_numbers");

        // Add each occurrence of each number to the occurences column
        for (Drawing d : drawings) {
            for (int i : d.numbersListInt) {
                numbers[i - 1][1]++;
            }
        }

        // Find the numbers with the highest amount of occurrences
        int[][] lucky = new int[5][2];
        
        for (int[] i : numbers) {
            for (int j = 0; j < 5; j++) {
                if (i[1] > lucky[j][1]) {
                    lucky[j][1] = i[1];
                    lucky[j][0] = i[0];
                    break;
                }
            }
        }

        // Print the numbers
        System.out.println("\nLuckiest lottery numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.println("#" + (i + 1) + ". " + lucky[i][0] + " with " + lucky[i][1] + " occurrences.");
        }
    }
}

class Drawing {

    private String numbers;
    public int[] numbersListInt;

    public Drawing(String nums) {
        numbers = nums;

        // Split the 6 numbers into an array
        String[] numbersList = numbers.split(" ");
        numbersListInt = new int[5];

        // Skip the 6th number because it only goes up to 26
        for (int i = 0; i < 5; i++) {
            numbersListInt[i] = Integer.parseInt(numbersList[i]);
        }
    }
}
