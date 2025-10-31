import java.util.Scanner;

public class Reactive {
    public static void main(String[] args) {
        System.out.println("IF you are Reactive Wolf type Y.");
        Scanner sc = new Scanner(System.in);

        System.out.println((sc.nextLine().toLowerCase().equals("y")) ? "\nIm unsubscribing\n" : "\nI love your youtube chnanel!\n");
        sc.close();
    }
}
