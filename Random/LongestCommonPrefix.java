import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<String>();

        System.out.println("Enter your words and type q to continue.");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        while (!input.equals("q")) {
            items.add(input);
            input = sc.nextLine();
        }

        String[] itemsList = items.toArray(new String[0]);

        String prefix = longestCommonPrefix(itemsList);

        System.out.println(prefix);

        sc.close();
    }

    public static String longestCommonPrefix(String[] strs) {

        String prefix = "";

        int i = 0;

        while (true) {

            String letter;

            try {
                letter = String.valueOf(strs[0].charAt(i));
            } catch (Exception e) {
                return prefix;
            }

            for (int i2 = 0; i2 < strs.length; i2++) {
                String letter2;
                try {

                    letter2 = String.valueOf(strs[i2].charAt(i));
                } catch (Exception e) {
                    return prefix;
                }

                if (!(letter.equals(letter2))) {
                    return prefix;
                }
            }

            prefix = prefix + letter;

            i++;
        }
    }

    // this one finds the shortest string in the list instead of a common prefix :skull:

    /*public static String longestCommonPrefix2(String[] strs) {

        String prefix = strs[0];

        if (prefix.equals(""))
            return "";
        if (strs.length == 1)
            return prefix;

        for (int i = 0; i < strs.length; i++) {
            if (strs[0] != strs[i]) {
                if (strs[0].length() > strs[i].length() && strs[0].contains(strs[i])) {
                    prefix = strs[i];
                }
            }
        }

        return prefix;

    }*/

}
