/*
 * Activity 4.1.2
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LunchMenu
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("4.1\\PhraseData\\lunches.txt"));

        ArrayList<String> twice = new ArrayList<String>();
        ArrayList<String> thrice = new ArrayList<String>();

        while (sc.hasNext()) {
            String[] info = sc.nextLine().split(": ");
            if (Integer.parseInt(info[1]) == 2) {
                twice.add(info[0]);
            } else if (Integer.parseInt(info[1]) == 3) {
                thrice.add(info[0]);
            }
        }

        sc.close();

        System.out.println("Served twice a month:");
        for (String m : twice) {
            System.out.println(m);
        }

        System.out.println("Served three times a month:");
        for (String m : thrice) {
            System.out.println(m);
        }
    }
}