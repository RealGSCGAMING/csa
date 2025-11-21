public class ValidPalindrome2 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("cbbcc"));
    }

    public static boolean validPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /*
     * 
     * boolean v = true;
     * boolean v2 = true;
     * 
     * 
     * // for each letter
     * for (int i = 0; i < s.length(); i++) {
     * 
     * // check if it equals the letter on the opposite side
     * if (v && s.charAt(i) != s.charAt(s.length() - i - 1))
     * v = false;
     * 
     * // remove the letter
     * String ns = s.substring(0, i) + s.substring(i + 1);
     * //System.out.println(ns);
     * 
     * v2 = true;
     * 
     * // for each letter in the new string
     * for (int i2 = 0; i2 < ns.length(); i2++) {
     * 
     * //System.out.println(ns.charAt(i2) + " == " + ns.charAt((ns.length() - i2 -
     * 1)));
     * 
     * if (ns.charAt(i2) != ns.charAt(ns.length() - (i2 + 1))) {
     * //System.out.println("Invalid\n");
     * v2 = false;
     * break;
     * }
     * }
     * 
     * if (v2) {
     * //System.out.println("Modified is valid");
     * return true;
     * }
     * 
     * }
     * 
     * if (v) {
     * //System.out.println("Normal is valid");
     * return true;
     * }
     * 
     * return false;
     * 
     * }
     * 
     */

}
