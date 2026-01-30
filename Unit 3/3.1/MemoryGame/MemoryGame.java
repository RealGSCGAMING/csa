package MemoryGame;

/**
 * Project 3.1.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of
 * buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
public class MemoryGame {
  public static void main(String[] args) {

    // TO DO: Create the "memory strings" - an array of at least 4 single character
    // strings to show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.
    String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v", "w", "x", "y", "z" };

    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.))
    MemoryGameGUI game = new MemoryGameGUI();

    int score = 0;
    int rounds = 1;
    double speed = 0.5;
    int buttons = 3;
    int numLetters = 3;

    String diff=game.difficultyChoice().toLowerCase();
    if(diff.equals("m")){
      speed = 0.4;
      buttons = 4;
      numLetters = 5;
    } else if(diff.equals("h")){
      speed = 0.3;
      buttons = 5;
      numLetters = 7;
    }
  
  
    game.createBoard(buttons, true);

    // TO DO: Play the game until user wants to quit.
    while (true) {

      
      

      // TO DO: Call the next method in RandomPermutation to create a random version
      // of the "memory strings"
      // adjust for difficulty

      String[] sequence = new String[numLetters];
      for (int i = 0; i < numLetters; i++) {
        sequence[i] = alphabet[i];
      }

      String[] randomSeq = RandomPermutation.next(sequence);
      // TO DO: Play one sequence with a .5 second delay. Save the player's guess.
      // (Later, you can speed up or slow down the game.)
      String guess = game.playSequence(randomSeq, speed);

      // TO DO: If the guess is not null, determine a match
      if (!(guess == null) && !guess.equals("")) {
        // TO DO: Cleanup the guess - repalce commas and spaces with the empty string.
        // Refer to a new String method replace.
        guess = guess.replace(",", "").replace(" ", "");
        // TO DO: Iterate to determine if all elements of the guess match sequence

        boolean matched = true;
        if (guess.length() > randomSeq.length || guess.length() < randomSeq.length) {
          matched = false;
        } else {
          for (int i = 0; i < guess.length(); i++) {
            if (!(guess.substring(i, i + 1).equals(randomSeq[i]))) {
              matched = false;
              break;
            }
          }
        }

        // If match, signal a match, otherwise, try again.
        if (matched) {
          game.matched();
          // increase score
          score++;
        } else {
          game.tryAgain();
        }

      }
      // TO DO: Ask if user wants to play another round of the game
      // and track the number of games played.
      boolean again = game.playAgain();
      if (!again) {
        // When done playing, show score and end the game.
        game.showScore(score, rounds);
        game.quit();
        break;
      }
      
      rounds++;
      speed *= 1.1;
      numLetters++;
      if (rounds % 2 == 0) {
        buttons++;
      }
    }

    
    
  }
}