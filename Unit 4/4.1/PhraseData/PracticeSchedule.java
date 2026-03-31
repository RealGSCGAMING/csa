
/* 
 * Activity 4.1.2
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PracticeSchedule {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(new File("4.1\\PhraseData\\schedule2.csv"));

        String str;
        String[] tokens;

        double hours = 0, totalHours = 0;
        
        sc1.nextLine();

        while (sc1.hasNext()) {
            str = sc1.nextLine();
            // CODE TO ADD
            tokens = str.split(",");
            hours = Double.parseDouble(tokens[1]);
            totalHours += hours;
            System.out.println(tokens[0] + " I practice " + tokens[1] + " hours.");
        }

        sc1.close();

        System.out.println("Total hours: " + totalHours);
        System.out.println("Average hours: " + (double) totalHours / 7);

    }
}