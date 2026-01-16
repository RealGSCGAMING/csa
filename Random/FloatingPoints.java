import java.sql.Time;
import java.util.Scanner;

public class FloatingPoints {
    public static void main(String[] args) {
        System.out.println("Enter the amount of floating point operations:");
        Scanner sc = new Scanner(System.in);
        int operations = sc.nextInt();
        sc.close();
        Time start = new Time(System.currentTimeMillis());
        double result = 0;

        for (int i = 0; i < operations; i++) {
            result += Math.sqrt(Math.random()) * Math.random() / (Math.random() + 1);
        }

        Time end = new Time(System.currentTimeMillis());
        System.out.println("Time: " + (end.getTime() - start.getTime()));
        System.out.println("Last result: " + result);
    }
}
