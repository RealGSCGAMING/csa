import java.util.ArrayList;
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(ArrayList<Integer> nums, int target) {

        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int i2 = nums.size() - 2; i2 >= 0; i2--) {

                    if (nums.get(i) + nums.get(i2) == target) {
                        int[] array = { i, i2 };
                        return array;
                    }
            }
        }

        int[] array = { -1 };

        return array;

    }

    public static ArrayList<Integer> getInput() {

        ArrayList<Integer> array = new ArrayList<Integer>(); 

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the TARGET NUMBER:");
        array.add(sc.nextInt());

        System.out.println("How many numbers do you want to check?");

        int inputs = sc.nextInt();
 
        for (int i = 1; i < inputs + 1; i++) {
            System.out.println("Enter input " + i);

            array.add(sc.nextInt());
        }
        
        sc.close();
        return array;

    }

    public static void main(String[] args) {
        
        ArrayList<Integer> array = getInput();

        int target = array.get(0);
        array.remove(0);

        int[] sums = twoSum(array, target);

        if (sums[0] == -1) {
            System.out.println("No possible sums.");
            return;
        }

        int num1 = sums[0];
        int num2 = sums[1];

        System.out.println("Sum indexes: " + num1 + ", " + num2);

    }
}
