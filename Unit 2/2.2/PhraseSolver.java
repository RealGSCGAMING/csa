
/*
 * Activity 2.2.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver {
  /* your code here - attributes */
  boolean solved;
  Board game = new Board();
  Player player1 = new Player(1);
  Player player2 = new Player(2);
  /* your code here - constructor(s) */

  public PhraseSolver() {

    solved = false;

  }

  public void play() {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    boolean found = false;
    String guess;
    while (!solved) {

      /* your code here - game logic */

      if (currentPlayer == 1) {
        System.out.print(player1.getName());
      } else {
        System.out.print(player2.getName());
      }

      System.out.println(", guess a letter or solve the phrase.");

      guess = input.nextLine();

      solved = game.isSolved(guess);

      if (solved) {
        System.out.println("\n");

        if (currentPlayer == 1) {
          System.out.print(player1.getName());
        } else {
          System.out.print(player2.getName());
        }
        System.out.println(", you solved the phrase!");
        break;
      }

      found = game.guessLetter(guess);

      if (found) {
        if (currentPlayer == 1) {
          player1.setPoints(player1.getPoints() + game.getLetterValue());
          System.out.println(player1.getName() + ", you now have " + player1.getPoints() + " points.\n");
        } else {
          player2.setPoints(player2.getPoints() + game.getLetterValue());
          System.out.println(player2.getName() + ", you now have " + player2.getPoints() + " points.\n");
        }
      } else {
        System.out.println("Sorry, that letter isn't in the phrase.\n");
      }

      if (currentPlayer == 1) {
        currentPlayer = 2;
      } else {
        currentPlayer = 1;
      }

      game.setLetterValue();

    }

    /* your code here - determine how game ends */

    System.out.println("\nThe winner is...");
    if (player1.getPoints() > player2.getPoints()) {
      System.out.println(player1.getName() + " with " + player1.getPoints() + " points!");
      System.out.println(player2.getName() + " has " + player2.getPoints() + " points.");
    }
    else if (player1.getPoints() < player2.getPoints()) {
      System.out.println(player2.getName() + " with " + player2.getPoints() + " points!");
      System.out.println(player1.getName() + " has " + player1.getPoints() + " points.");
    }
    else {
      System.out.println("...it's a tie! Both players have " + player1.getPoints() + " points!");
    }

    System.out.println("\nThanks for playing!");
    input.close();
  }

}