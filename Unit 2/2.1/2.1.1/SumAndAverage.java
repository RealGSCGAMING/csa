
/*
 * Activity 2.1.1
 */
import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of values in your sequence: ");
        int numValues = sc.nextInt();

        int i = 1;
        int sum = 0;
        int i2 = numValues;

        /* Your code here */
        while (i2 > 0) {
            System.out.println("Enter value " + i);
            int value = sc.nextInt();

           sum += value;

            i2--;
            i++;
        }

        int average = sum / numValues;

        System.out.println("Sum of values: " + sum);
        System.out.println("Average of values: " + average);
        sc.close();

    }

}