import java.util.Random;

public class Board {
    private static int pieces;


    public static void populate() {
        Random r = new Random();
        pieces = r.nextInt(41) + 10; // 10..50 inclusive
    }

    public static int getPieces() {
        return pieces;
    }

    /** Remove n pieces from the board (assumes caller validated n). */
    public static void takePieces(int n) {
        pieces -= n;
        if (pieces < 0) pieces = 0;
    }
}
