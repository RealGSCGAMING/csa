/*
 * Activity 4.2.3
 */
public class RecurseString {
    public static void main(String args[]) {
        String str = "abcdefgh";
        System.out.println("A new string from " + str + ": " + what(str));
        System.out.println("Another new string from " + str + ": " + revStr(str));
        mystery(0, 1, 7);
    }

    /**
     * Some recursion
     */
    public static String what(String str) {
        // base case
        if (str.length() == 1) {
            return str.substring(0);
        }
        return what(str.substring(1)) + str.substring(0, 1);

    }

    /**
     * Reverse a string using an iterative algorithm
     */
    public static String revStr(String str) {
        String newstr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            newstr += str.substring(i, i + 1);
        }

        return newstr;
    }

    public static void mystery(int n1, int n2, int count) {
        if (count > 0) {
            if (n1 == 0)
                System.out.print(n1 + " ");
            else if (n2 == 1)
                System.out.print(n2 + " ");

            System.out.print((n1 + n2) + " ");
            mystery(n2, n1 + n2, count - 1);
        } else
            return;
    }
}
