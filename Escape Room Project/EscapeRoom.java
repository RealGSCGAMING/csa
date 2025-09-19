/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jumpright", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?", "checkright", "cr", "checkleft", "cl",
    "checkup", "cu", "checkdown", "cd", "sr", "springright", "sl", "springleft", "su", "springup",
    "sd", "springdown"};
  
    String playerInput;

    // set up game
    boolean play = true;
    while (play)
    {
      /* TODO: get all the commands working */
	  /* Your code here */

      playerInput = UserInput.getValidInput(validCommands);

      // movement commands

      if (playerInput.equals("u") || playerInput.equals("up")) { // up
        score += game.movePlayer(0, -60);
      }

      else if (playerInput.equals("d") || playerInput.equals("down")) { // down
        score += game.movePlayer(0, 60);
      }

      else if (playerInput.equals("l") || playerInput.equals("left")) { // left
        score += game.movePlayer(-60, 0);
      }

      else if (playerInput.equals("r") || playerInput.equals("right")) { // right
        score += game.movePlayer(60, 0);
      }

      // pickup command

      else if (playerInput.equals("p") || playerInput.equals("pickup")) {
        score += game.pickupPrize();
      }

      // jumping commands

      else if (playerInput.equals("jump")) { // no direction
        System.out.println("You must input a direction to use Jump.");
      }

      else if (playerInput.equals("ju") || playerInput.equals("jumpup")) { // up
        score += game.movePlayer(0, -120);
      }

      else if (playerInput.equals("jd") || playerInput.equals("jumpdown")) { // down
        score += game.movePlayer(0, 120);
      }

      else if (playerInput.equals("jl") || playerInput.equals("jumpleft")) { // left
        score += game.movePlayer(-120, 0);
      }

      else if (playerInput.equals("jr") || playerInput.equals("jumpright")) { // right
        score += game.movePlayer(120, 0);
      }

      // quit command
      
      else if (playerInput.equals("q") || playerInput.equals("quit")) {
        score += game.endGame();
        play = false;
      }

      // replay command

      else if (playerInput.equals("replay")) {
        score += game.replay();
      }

      // check commands

      else if (playerInput.equals("cu") || playerInput.equals("checkup")) {
        game.isTrap(0, -60);
      }

      else if (playerInput.equals("cd") || playerInput.equals("checkdown")) {
        game.isTrap(0, 60);
      }

      else if (playerInput.equals("cl") || playerInput.equals("checkleft")) {
        game.isTrap(-60, 0);
      }

      else if (playerInput.equals("cr") || playerInput.equals("checkright")) {
        game.isTrap(60, 0);
      }

      // spring commands

      else if (playerInput.equals("su") || playerInput.equals("springup")) {
        game.springTrap(0, -60);
      }
      
      else if (playerInput.equals("sd") || playerInput.equals("springup")) {
        game.springTrap(0, 60);
      }

      else if (playerInput.equals("sl") || playerInput.equals("springup")) {
        game.springTrap(-60, 0);
      }

      else if (playerInput.equals("sr") || playerInput.equals("springup")) {
        game.springTrap(60, 0);
      }

      // help command

      else if (playerInput.equals("help") || playerInput.equals("?")) {
        
        System.out.println("Commands:");
        System.out.println("Move - moves one space: right, left, u, d");
        System.out.println("Jump - moves two spaces: jumpright, jumpleft, ju, jd");
        System.out.println("Pickup - picks up a coin: pickup, p");
        System.out.println("Replay - Return to the starting point: replay");
        System.out.println("Quit - End the game: quit, q");
        System.out.println("Check - check for a trap: checkright, checkleft, cu, cd");
        System.out.println("Spring - spring a trap: springright, springleft, su, sd");

      }

    }

  

    score += game.endGame();

    System.out.println("\nscore = " + score);
    System.out.println("steps = " + game.getSteps());
  }
}

        