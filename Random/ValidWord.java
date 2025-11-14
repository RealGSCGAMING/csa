import java.util.ArrayList;
import java.util.Arrays;

public class ValidWord {

    public static void main(String[] args) {
        System.out.println(isValid("Ya$"));
    }

    public static boolean isValid(String word) {

        String[] vowels = { "a", "e", "i", "o", "u" };
        ArrayList<String> vowels2 = new ArrayList<String>(Arrays.asList(vowels));

        boolean vo = false;
        boolean co = false;

        if (word.length() >= 3) {

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (Character.isLetterOrDigit(ch)) {

                    String c = String.valueOf(word.charAt(i)).toLowerCase();
                    if (vowels2.contains(c)) {
                        vo = true;
                    } else if (!(Character.isDigit(ch))) {
                        co = true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (vo && co) {
            return true;
        } else {
            return false;
        }
    }
}