/* 
 * Activity 4.1.2
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HorseData
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("4.1\\PhraseData\\horsedata.txt"));

        int sumWeight = 0;
        double sumAge = 0;
        int length = 0;

        for (length = 0; sc.hasNext(); length++) {
            String n = sc.next();
            int w = sc.nextInt();
            double a = sc.nextDouble();
            boolean isNew = sc.nextBoolean();

            sumWeight += w;
            sumAge += a;

            System.out.println(n + " is " + a + " years old and weighs " + w + " pounds. They are" + (isNew ? "" : " not") + " new to the barn.");
        }

        sc.close();

        double avgWeight = (double) sumWeight / length;
        double avgAge = (double) sumAge / length;

        System.out.println("Average weight: " + avgWeight);
        System.out.println("Average age: " + avgAge);

        int hay = (int) (sumWeight * 0.025);
        System.out.println("Hay needed: " + hay);
    }
}