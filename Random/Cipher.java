import java.util.Scanner;

public class Cipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        String code;

        // DELETE
        sc.close();

        while (true) {
            System.out.println("Encrypt (1) or decrypt (2)");
            input = sc.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter text");
                input = sc.nextLine();
                code = encode(input, 1);
                System.out.println(code);
            }

            if (input.equals("2")) {
                System.out.println("Enter encoded text");
                input = sc.nextLine();
                code = decode(input, 1);
                System.out.println(code);
            }
        }
    }

    public static String encode(String inputString, int key) {
        return "delete this";
    }

    public static String decode(String inputString, int key) {
        return "delete this";
    }

    public static String letterFinder(String letter) {

        letter = letter.toLowerCase();

        String[] letters = {"a", "b"};

        // DELETE
        System.out.println(letters);
        

        if (letter.equals("a")) {
            //letterid = 1;
        }
        if (letter.equals("b")) {
        }
        if (letter.equals("c")) {

        }
        return "delete this";
        
    }

}
