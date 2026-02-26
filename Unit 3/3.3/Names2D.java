/*
 * Activity 3.3.3
*/
public class Names2D {
    public static void main(String[] args) {
        String[][] names = { { "Ari", "Avery", "Ash", "Aman" },
                { "Brynn", "Bodie", "Bo", "Barrie" },
                { "Cris", "Carter", "Cali", "Ari" } };

        System.out.println("Initial array:");
        print2DArray(names);
        System.out.println();

        System.out.print("Determine if there are duplicate names: ");
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                for (int i2 = i + 1; i2 < names.length; i2++) {
                    for (int j2 = j + 1; j2 < names[i2].length; j2++) {
                        if (names[i][j].equals(names[i2][j2])) {
                            System.out.print(names[i][j] + " ");
                        }
                    }
                }
            }
        }

        System.out.println();

        System.out.println("\nAccess consecutive pairs of elements in each row:");
        for (String[] i : names) {
            for (int j = 0; j < i.length - 1; j += 2) {
                System.out.println(i[j] + " and " + i[j + 1]);
            }
        }

        System.out.println("\nReverse the order of the elements in second column:");

        for (int i = 0; i < names.length / 2; i++) {
            String temp = names[i][1];
            names[i][1] = names[names.length - i - 1][1];
            names[names.length - i - 1][1] = temp;
        }

        print2DArray(names);

        System.out.println(
                "\nShift an element in a row: Shift the first name in the first row left to the last name in the row:");
        for (int i = 0; i < names[0].length - 1; i++) {
            String temp = names[0][i];
            names[0][i] = names[0][i + 1];
            names[0][i + 1] = temp;
        }

        print2DArray(names);

        System.out
                .println("\nShift an element in a column: Shift the last name in the first row down to the last row:");
        for (int i = 0; i < names.length - 1; i++) {
            String temp = names[i][names[0].length - 1];
            names[i][names[0].length - 1] = names[i + 1][names[0].length - 1];
            names[i + 1][names[0].length - 1] = temp;
        }

        print2DArray(names);

    }

    public static void print2DArray(String[][] array) {
        for (String[] i : array) {
            for (String j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
