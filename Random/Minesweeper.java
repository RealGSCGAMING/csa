// This is trash

import java.util.ArrayList;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Which cell do you want to check? Enter it as a coordinate pair (x y): ");
        String input = sc.nextLine();
        try {
            int num1 = Integer.parseInt(input.substring(0, input.indexOf(" "))) + 1;
            int num2 = Integer.parseInt(input.substring(input.indexOf(" ") + 1)) + 1;

            if (board.cells.get(num2 * board.width + num1).isMine) {
                System.out.println("BOOM! You hit a mine!");
            } else {
                System.out.println("Safe! No mine here.");
            }
        }
        catch (Exception e) {
            
        }
    }

}

class Board {

    int width, height, numCells, mines;
    ArrayList<Cell> cells = new ArrayList<>();

    public Board() {
        width = 10;
        height = 10;
        mines = 0;
        numCells = width * height;

        fillBoard(numCells);
    }

    private void fillBoard(int numCells) {

        for (int i = 0; i < numCells; i++) {
            if (Math.random() < 0.2) {
                cells.add(new Cell(true));
                System.out.println(i);
                mines++;
            } else {
                cells.add(new Cell(false));
            }
        }
        
    }

}

class Cell {

    boolean isMine;
    boolean isRevealed;

    public Cell(boolean isMine) {
        this.isMine = isMine;
        isRevealed = false;
    }
}