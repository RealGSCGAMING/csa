import java.util.Scanner;

public class Cipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        String code;

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
        // sc.close();
    }

    public static String encode(String inputString, int key){

        int length = inputString.length();
        int index = 0;
        String code = "";
        char letter;
        int letterid;

        while (index < length - 1) {

            letter = inputString.charAt(index);
            letterid = ((int) (letter));
            code = code + letterid;
            index++;
        }

        return code;
    }


    public static String decode(String inputString, int key) {
        
        int length = inputString.length();
        int index = 0;
        String code = "";
        int letter;
        char letterid;

        while (index < length - 1) {

            letter = inputString.charAt(index) + inputString.charAt(index + 1);
            letterid = ((char) (letter));
            System.out.println((char) (letter));
            code = code + letterid;
            index += 2;
        }

        return code;
    }

}
