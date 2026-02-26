/*
 * Activity 3.3.3
*/
public class Numbers2D
{
  public static void main(String[] args)
  {
    int[][] numbers = { {1,5,3,8,-3,0,3},
                      {4,4,8,0,3,-1,1}, 
                      {0,3,8,4,-2,7, 6} };

    int sum = 0;
    int count = 0;
    int min = numbers[0][0];
    int max = numbers[0][0];
    int negatives = 0;

    for (int[] i : numbers) {
        for (int j : i) {
            sum += j;
            if (j < min) min = j;
            if (j > max) max = j;
            if (j < 0) negatives++;
            count++;
        }
    }

    double average = (double) sum / count;

    System.out.println("Sum: " + sum);
    System.out.println("Average: " + average);
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
    System.out.println("Negatives: " + negatives);

  }
}
