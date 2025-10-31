import java.util.*;

public class Game {
    public Player player1;
    public Player player2;
    public Player winner;

    private final Scanner in = new Scanner(System.in);
    private final Random rand = new Random();

    public Player play() {
        System.out.println("\n=== Nim Setup ===");

        // Create Player 1
        player1 = new Player();
        System.out.print("Enter Player 1 name: ");
        player1.setName(readNonEmptyLine());

        // Choose Bot or 2-player
        boolean vsBot = askYesNo("Play against a bot? (y/n) ");
        boolean botVsBot = false;
        boolean fast = false;
        int times = 0;

        int p1turns = 0;
        int p2turns = 0;

        // Choose Player vs. Bot or Bot vs. Bot
        if (vsBot) {
            botVsBot = askYesNo("Bot vs Bot? (y/n) ");
            if (botVsBot) {
                player1.setType(true);
                fast = askYesNo("Would you like to simulate multiple games quickly (y) or watch individual games (n)?");
                if (fast) {
                    System.out.println("Press Enter to begin the simulation.");
                    in.nextLine();
                }
                else {
                    System.out.println("Press Enter to advance the simulation.");
                    in.nextLine();
                }
            }
        }

        // Create Player 2
        player2 = new Player();
        if (vsBot) {
            player2.setType(true);
            player2.setName(randomBotName());
            System.out.println("You'll play against bot: " + player2.getName());
        } else {
            System.out.print("Enter Player 2 name: ");
            player2.setName(readNonEmptyLine());
        }

        boolean playAgain = true;

        // repeat until not playing again
        do {
            // New game setup
            Board.populate();
            winner = null;
            System.out.println("\n--- New Game ---");
            System.out.println("Starting pile size: " + Board.getPieces() + " pieces");

            // Randomly choose who starts
            Player current = rand.nextBoolean() ? player1 : player2;
            System.out.println("First turn: " + current.getName());

            if (current.equals(player1)) {
                p1turns++;
            }
            else {
                p2turns++;
            }

            // Turn loop
            while (Board.getPieces() > 0) {
                int pile = Board.getPieces();
                int maxTake = Math.max(1, pile / 2);

                System.out.println("\nPile: " + pile + " pieces");
                System.out.println(current.getName() + "'s turn. You may take 1 to " + maxTake + " pieces.");

                // if bot vs bot game, wait for user to press enter before moving on
                if (botVsBot && !fast) {
                    in.nextLine();
                }

                int take;
                if (current.isBot()) {
                    // If the current player is a bot, get the bot's move
                    take = calculateBotMove(pile, maxTake); // OLD SIMPLE BOT: rand.nextInt(maxTake) + 1;
                    System.out.println(current.getName() + " (bot) takes " + take + ".");
                } else {
                    take = readIntInRange("Enter pieces to take: ", 1, maxTake);
                }

                Board.takePieces(take);

                // if bot vs bot game, wait for user to press enter before moving on
                if (botVsBot && !fast) {
                    in.nextLine();
                }

                // If pile is now empty, current player took the last piece and LOSES
                if (Board.getPieces() == 0) {
                    winner = (current == player1) ? player2 : player1;
                    winner.incrementScore();
                    System.out.println("\n*** " + current.getName() + " took the last piece and loses. ***");
                    System.out.println(">>> Winner: " + winner.getName() + " <<<");
                    break;
                }

                // Swap turns
                current = (current == player1) ? player2 : player1;
            }

            // Scoreboard
            displayScoreboard();

            if (fast) {
                if (times == 50) {
                    System.out.println(player1.getName() + " had " + player1.getScore() + " points and went first " + p1turns + " times.");
                    System.out.println(player2.getName() + " had " + player2.getScore() + " points and went first " + p2turns + " times.");
                    System.out.println("As you can see, if you go first, you are more likely to win!");
                    break;
                }
                else {
                    times++;
                }
            }
            else {
            // Play again?
            playAgain = askYesNo("Play again? (y/n) ");
            if (playAgain) {
                // Prepare for a new game: just repopulate and pick a new first player inside
                // the loop
                System.out.println();
            }
        }
        } while (playAgain);

        // display the winner when quitting
        System.out.println((player1.getScore() == player2.getScore())
                ? "Both players have tied with " + winner.getScore() + " points!"
                : "\nThe winner is " + winner.getName() + " with " + winner.getScore() + " points!");
        System.out.println("\nThanks for playing!\n");
        return winner;
    }

    // prints the current game scoreboard
    private void displayScoreboard() {
        System.out.println("\n=== Scoreboard ===");
        System.out.printf("%s: %d\n", player1.getName(), player1.getScore());
        System.out.printf("%s: %d\n", player2.getName(), player2.getScore());
        System.out.println("==================");
    }

    // gets a y/n input
    private boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes"))
                return true;
            if (s.equals("n") || s.equals("no"))
                return false;
            System.out.println("Please enter y/n.");
        }
    }

    // ensures input is not empty
    private String readNonEmptyLine() {
        while (true) {
            String s = in.nextLine().trim();
            if (!s.isEmpty())
                return s;
            System.out.print("Please enter a non-empty name: ");
        }
    }

    // ensures entered number is within range
    private int readIntInRange(String prompt, int lo, int hi) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                int val = Integer.parseInt(s);
                if (val < lo || val > hi) {
                    System.out.println("Enter an integer from " + lo + " to " + hi + ".");
                } else {
                    return val;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    // generates a random bot name
    private String randomBotName() {
        String[] names = { "HAL", "Robo", "BitCrusher", "Nim", "Ada", "Turing" };
        return names[rand.nextInt(names.length)] + ((int) (Math.random() * 9000) + 1000);
    }

    // calculates the move a bot will make
    private int calculateBotMove(int currentPieces, int maxTake) {

        int bestNum = 0;

        // skip the loop if it can only take 1
        if (maxTake == 1) {
            return 1;
        }

        for (int i = 1; i <= maxTake; i++) {

            // if it can reduce the pile size to 3 or 7 by taking i, do it
            if (currentPieces - i == 3) {
                return i;
            } else if (currentPieces - i == 7) {
                return i;
            } else {

                // simulate the other player's situation after taking i
                int newCurrent = currentPieces - i;
                int newMaxTake = Math.max(1, newCurrent / 2);

                // if by taking i, the 2nd player will not be able to make the pile size 3 or 7,
                // set i as the new best choice
                if (newCurrent - newMaxTake > 3 && newCurrent - newMaxTake > 7) {
                    bestNum = i;
                } else {
                }
            }
        }

        // take as many pieces as possible without letting the other player win
        if (bestNum != 0) {
            return bestNum;
        }

        // if bot can't put itself in a winning situation, take a random amount
        return rand.nextInt(maxTake) + 1;
    }
}
