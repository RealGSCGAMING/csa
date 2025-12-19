import java.util.Scanner;

public class TenMinuteRobotChallenge {

    static int joystick = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // initial joystick print
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n O\n |\n---");

        while (true) {
            System.out.println("What direction do you want to push the joystick? (L, R, or press Q to quit)");

            while (true) {
                String inp = sc.nextLine();
                if (processInput(inp))
                    break;
            }

            // quit if input is q
            if (joystick == 66) {
                break;
            }

            printJoystick();

            printMotorStates();
        }

        sc.close();
    }

    public static boolean processInput(String inp) {
        if (inp.toLowerCase().equals("r")) {
            if (joystick == 0) {
                joystick = 1;
            } else if (joystick == -1) {
                joystick = 0;
            } else {
                System.out.println("The joystick is already pointing in that direction.");
                return false;
            }
        }

        else if (inp.toLowerCase().equals("l")) {
            if (joystick == 1) {
                joystick = 0;
            } else if (joystick == 0) {
                joystick = -1;
            } else {
                System.out.println("The joystick is already pointing in that direction.");
                return false;
            }
        }

        else if (inp.toLowerCase().equals("q")) {
            joystick = 66;
        }

        else {
            System.out.println("Please enter a direction (L/R)");
            return false;
        }

        return true;
    }

    public static void printJoystick() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        if (joystick == 0)
            System.out.println(" O\n |\n---\nThe joystick is neutral.");
        else if (joystick == 1)
            System.out.println("   O\n  /\n---\nThe joystick is pushed to the right.");
        else if (joystick == -1)
            System.out.println("O\n \\\n ---\nThe joystick is pushed to the left.");
    }

    public static void printMotorStates() {
        for (int i = 0; i < 4; i++) {
            System.out.print("Motor " + (i + 1) + " is ");
            if (joystick == 0)
                System.out.println("not turning.");
            else if (joystick == -1)
                System.out.println("turning counterclockwise.");
            else if (joystick == 1)
                System.out.println("turning clockwise.");

        }
    }
}