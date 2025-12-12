import java.util.Scanner;

public class FlipCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press ENTER to flip 2,000,000 coins");
        sc.nextLine();

        int heads = 0;
        int tails = 0;

        for (int i = 0; i < 2000000; i++) {
            if (Math.random() > 0.5) {
                heads++;
                System.out.println("Flipped coin " + i + " and got heads");
            }
            else {
                tails++;
                System.out.println("Flipped coin " + i + " and got tails");
            }
        }

        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);

        if (heads > tails) {
            System.out.println("Result: Heads");
        }
        else {
            System.out.println("Result: Tails");
        }
    }
}
