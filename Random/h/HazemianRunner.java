package h;

import java.util.Scanner;

public class HazemianRunner {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to Hazemia Simulator\nHow many random hazemians do you want");

        Chat c = new Chat(getNumberInput());

        System.out.println("Do you want any custom hazemians (Y/N)");

        if (sc.nextLine().toLowerCase().equals("y")) {
            while (true) {
                System.out.println("\nEnter the name of your hazemian or press q to continue");
                String tempN = sc.nextLine();
                if (tempN.toLowerCase().equals("q"))
                    break;
                System.out.println("Enter your hazemian's level");
                int tempL = getNumberInput();
                Hazemian h = new Hazemian(tempL, tempN);
                c.addHazemian(h);
                System.out.println("Added " + h.getName());
            }
        }

        System.out.println("How many messages do you want");
        int time = getNumberInput();

        System.out.println("\n----- STARTING SIMULATION -----\n");

        for (int i = 0; i < time; i++) {
            waitSecs((int) (Math.random() * 2) + 1);
            c.simulate();
        }

        System.out.println("----- SIMULATION ENDED -----\n");

    }

    public static void waitSecs(int s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getNumberInput() {
        while (true) {
            try {
                int r = Integer.valueOf(sc.nextLine());
                return r;
            } catch (Exception e) {
                System.out.println("You need to enter an integer");
            }
        }
    }
}
