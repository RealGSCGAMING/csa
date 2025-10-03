public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] hi = { "flower", "flow", "flight" };

        System.out.println(longestCommonPrefix2(hi));
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

    public static String longestCommonPrefix2(String[] strs) {

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

    }

}
