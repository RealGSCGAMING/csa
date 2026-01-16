public class TryExample {
    public static void main(String[] args) {

        try {

            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[5]);

        } catch (Exception e) {

            System.out.println("An error occurred: " + e.getMessage());

        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Sleep was interrupted: " + e.getMessage());
        }
    }
}
