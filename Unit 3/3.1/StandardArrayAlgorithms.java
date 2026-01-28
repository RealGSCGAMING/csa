/*
 * Activity 3.1.4
 */
public class StandardArrayAlgorithms {
    public static void main(String[] args) {
        int[] goals = { 1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, 2 };

        int sum = 0;
        for (int i = 0; i < goals.length; i++)
            sum += goals[i];

        System.out.println("All goals: " + sum);

        double average = (double) sum / goals.length;
        System.out.println("Average goals: " + average);

        int min = goals[0], max = goals[0];
        for (int i = 1; i < goals.length - 1; i++) {
            if (goals[i] > max)
                max = goals[i];
            if (goals[i] < min)
                min = goals[i];
        }

        System.out.println("Min goals: " + min);
        System.out.println("Max goals: " + max);

        // CODE TO ADD
        Player[] players = { new Player("Alex", 12), new Player("Aiden", 13),
                new Player("Bobbie", 18), new Player("Blaine", 20),
                new Player("Chris", 15), new Player("Charlie", 15) };

        int i = 0;
        boolean hasValue = false;
        while (i < players.length - 1) {
            if (players[i].getAge() >= 18) {
                hasValue = true;
                break;
            }
            i++;
        }

        if (hasValue)
            System.out.println("Player over 18 found");
        else
            System.out.println("Player over 18 not found");

        boolean allHaveValue = true;
        for (Player p : players) {
            if (p.getAge() >= 21) {
                allHaveValue = false;
                break;
            }
        }

        if (allHaveValue)
            System.out.println("All players are under 21");
        else
            System.out.println("At least one player is 21 or older");

        int v = 0;
        for (Player p : players) {
            if (p.getAge() == 15)
                v++;
        }

        if (v > 0)
            System.out.println("Players age 15: " + v);
        else
            System.out.println("No players are age 15");

        for (int j = 0; j < players.length; j += 2) {
            System.out.println(players[j].getName() + " and " + players[j + 1].getName());
        }

        // Algorithm 1: Moves the first item to the end
        int[] array1 = { 1, 2, 3, 4, 5, 6 };
        for (int j = 0; j < array1.length - 1; j++) {
            int temp = array1[j];
            array1[j] = array1[j + 1];
            array1[j + 1] = temp;
        }
        printIntArray(array1);

        // Algorithm 2: Moves the last element to the beginning
        int[] array2 = {1,2,3,4,5,6};
        for (int j = array2.length - 1; j > 0; j--) {
            int temp = array2[j-1];
            array2[j-1] = array2[j];
            array2[j] = temp;
        }
        printIntArray(array2);

        // Algorithm 3: Reverses the order of the array
        int[] array3 = {1,2,3,4,5,6};
        int i1 = 0;
        int i2 = array3.length - 1;
        for (int j = 0; j < array3.length / 2; j++) {
            int temp = array3[i1];
            array3[i1] = array3[i2];
            array3[i2] = temp;
            i1++;
            i2--;
        }
        printIntArray(array3);
    }

    public static void printIntArray(int[] array) {
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

}

class Player {
    private String name;
    private int age;

    /* constructors */
    public Player() {
        this.name = "";
        this.age = 0;
    }

    public Player(String name) {
        this.name = name;
        this.age = 0;
    }

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* accessors */
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /* mutators */
    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int age) {
        this.age = age;
    }

}