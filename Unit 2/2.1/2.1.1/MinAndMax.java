
/*
 * Activity 2.1.1
 */
import java.util.Scanner;

public class MinAndMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of values in your sequence: ");
        int numValues = sc.nextInt();

        int i = 1;
        int greatest = 0;
        int smallest = 0;

        /* Your code here */
        while (numValues > 0) {
            System.out.println("Enter value " + i);
            int value = sc.nextInt();

            if (i == 1) {
                greatest = value;
                smallest = value;
            }

            if (value > greatest) {
                greatest = value;
            }
            if (value < smallest) {
                smallest = value;
            }

            numValues--;
            i++;
        }

        System.out.println("Greatest value: " + greatest);
        System.out.println("Smallest value: " + smallest);
        sc.close();

    }

}