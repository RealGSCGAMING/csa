import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Hash {
    public static void main(String[] args) {
        System.out.println("Guess the Passcode! No cheating, don't look at the source code pls");

        Scanner sc = new Scanner(System.in);

        while (true) {
            String inp = sc.nextLine();
            if (hashStringSHA256(inp).equals("49d180ecf56132819571bf39d9b7b342522a2ac6d23c1418d3338251bfe469c8")) {
                System.out.println("You did it!");
                break;
            } else {
                System.out.println("Wrong, try again!");
            }
        }

        sc.close();
    }

    public static String hashStringSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

            // Alternatively, for a Base64 encoded string:
            // return Base64.getEncoder().encodeToString(hashBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
