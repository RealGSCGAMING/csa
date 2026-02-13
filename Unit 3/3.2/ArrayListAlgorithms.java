import java.util.ArrayList;

public class ArrayListAlgorithms {
    static ArrayList<Integer> arrList = getArray();

    public static void main(String[] args) {

        System.out.println(arrList);
        System.out.println(algorithm1());
        System.out.println(algorithm2());
        System.out.println(algorithm3());
        System.out.println(algorithm4());
        System.out.println(algorithm5());
        System.out.println(algorithm6());
        System.out.println(algorithm7());
        System.out.println(algorithm8());
        System.out.println(algorithm9());
        System.out.println(algorithm10());
        System.out.println(algorithm11());

    }

    // Find the number of values equal to 0 in arrList
    static int algorithm1() {
        int x = 0;
        for (int a : arrList)
            if (a == 0)
                x++;
        return x;
    }

    // Find the minimum value in arrList
    static int algorithm2() {
        int y = arrList.get(0);
        for (int j = 1; j < arrList.size(); j++)
            if (arrList.get(j) < y)
                y = arrList.get(j);
        return y;
    }

    // Find the average of the values in arrList
    static double algorithm3() {
        double y = 0;
        for (double a : arrList)
            y += a;
        return (y / arrList.size());
    }

    // Find whether any of the values in arrList are equal to 0
    static boolean algorithm4() {
        int x = 0;
        boolean b = false;
        while (!b && (x < arrList.size())) {
            if (arrList.get(x) == 0)
                b = true;
            x++;
        }
        return b;
    }

    // Reverses the order of arrList
    static ArrayList<Integer> algorithm5() {
        ArrayList<Integer> newList = new ArrayList<>(arrList);
        int size = newList.size();
        for (int i = 0; i < newList.size() / 2; i++) {
            int a = newList.get(i);
            newList.set(i, newList.get(size - i - 1));
            newList.set(size - i - 1, a);
        }
        return newList;
    }

    // Find the sum of the values in arrList
    static int algorithm6() {
        int x = 0;
        for (int a : arrList)
            x += a;
        return x;
    }

    // Check if arrList contains any duplicate values
    static boolean algorithm7() {
        for (int i = 0; i < arrList.size(); i++)
            for (int j = i + 1; j < arrList.size(); j++)
                if (arrList.get(i) == arrList.get(j))
                    return true;
        return false;
    }

    // Flips the order of every pair of values in arrList
    static ArrayList<Integer> algorithm8() {
        ArrayList<Integer> newList = new ArrayList<>(arrList);
        for (int i = 0; i < newList.size() - 1; i += 2) {
            int a = newList.get(i);
            newList.set(i, newList.get(i + 1));
            newList.set(i + 1, a);
        }
        return newList;
    }

    // Checks if all the values in arrList are positive and not equal to zero
    static boolean algorithm9() {
        boolean b = true;
        for (int a : arrList)
            if (a <= 0)
                b = false;
        return b;
    }

    // Moves the last element to the beginning of arrList
    static ArrayList<Integer> algorithm10() {
        ArrayList<Integer> newList = new ArrayList<>(arrList);
        for (int x = newList.size(); x > 1; x--) {
            int a = newList.get(x - 2);
            newList.set(x - 2, newList.get(x - 1));
            newList.set(x - 1, a);
        }
        return newList;
    }

    // Finds the maximum value in arrList
    static int algorithm11() {
        int n = arrList.get(0);
        for (int y = 1; y < arrList.size(); y++)
            if (arrList.get(y) > n)
                n = arrList.get(y);
        return n;
    }

    private static ArrayList<Integer> getArray() {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(0);
        arrList.add(3);
        arrList.add(2);
        arrList.add(4);
        return arrList;
    }

}