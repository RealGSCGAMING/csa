package Concentration;

/*
 * Activity 3.3.1
 */
public class TileTester {
    private static String[] tileValues = { "lion", "lion",
            "penguin", "penguin",
            "dolphin", "dolphin",
            "fox", "fox",
            "monkey", "monkey",
            "turtle", "turtle" };

    public static void main(String[] args) {

        /* your code here */
        Tile[][] gameboard = new Tile[3][4];

        int valuesUsed = 0;
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                gameboard[i][j] = new Tile(tileValues[valuesUsed]);
                valuesUsed++;
            }
        }

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                System.out.println(gameboard[i][j]);
            }
        }

    }
}
