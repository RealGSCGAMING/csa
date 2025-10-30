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

        boolean playAgain;
        do {
            // New game setup
            Board.populate();
            winner = null;
            System.out.println("\n--- New Game ---");
            System.out.println("Starting pile size: " + Board.getPieces() + " pieces");

            // Randomly choose who starts
            Player current = rand.nextBoolean() ? player1 : player2;
            System.out.println("First turn: " + current.getName());

            // Turn loop
            while (Board.getPieces() > 0) {
                int pile = Board.getPieces();
                int maxTake = Math.max(1, pile / 2);

                System.out.println("\nPile: " + pile + " pieces");
                System.out.println(current.getName() + "'s turn. You may take 1 to " + maxTake + " pieces.");

                int take;
                if (current.isBot()) {
                    // Simple bot: random legal move
                    take = calculateBotMove(pile, maxTake); // rand.nextInt(maxTake) + 1;
                    System.out.println(current.getName() + " (bot) takes " + take + ".");
                } else {
                    take = readIntInRange("Enter pieces to take: ", 1, maxTake);
                }

                Board.takePieces(take);

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

            // Play again?
            playAgain = askYesNo("Play again? (y/n) ");
            if (playAgain) {
                // Prepare for a new game: just repopulate and pick a new first player inside
                // the loop
                System.out.println();
            }
        } while (playAgain);

        System.out.println((player1.getScore() == player2.getScore())
                ? "Both players have tied with " + winner.getScore() + " points!"
                : "\nThe winner is " + winner.getName() + " with " + winner.getScore() + " points!");
        System.out.println("\nThanks for playing!\n");
        return winner;
    }

    private void displayScoreboard() {
        System.out.println("\n=== Scoreboard ===");
        System.out.printf("%s: %d\n", player1.getName(), player1.getScore());
        System.out.printf("%s: %d\n", player2.getName(), player2.getScore());
        System.out.println("==================");
    }

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

    private String readNonEmptyLine() {
        while (true) {
            String s = in.nextLine().trim();
            if (!s.isEmpty())
                return s;
            System.out.print("Please enter a non-empty name: ");
        }
    }

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

    private String randomBotName() {
        String[] names = { "HAL", "Robo", "BitCrusher", "Nim", "Ada", "Turing" };
        return names[rand.nextInt(names.length)] + ((int) (Math.random() * 9000) + 1000);
    }

    private int calculateBotMove(int currentPieces, int maxTake) {

        for (int i = 1; i <= maxTake; i++) {
            if (currentPieces - i == 3) {
                System.out.println("Bot: I'm going to win.");
                return i;
            } else {

                int newCurrent = currentPieces - i;

                int newMaxTake = Math.max(1, newCurrent / 2);

                // System.out.println(newCurrent);
                // System.out.println(newMaxTake);

                if (newCurrent - newMaxTake == 3) {
                    System.out.println("Bot: This number won't work: " + i);

                } else {

                    boolean valid = true;

                    for (int i2 = 1; i2 <= newMaxTake; i2++) {
                        if (!(newCurrent - i2 == 3)) {
                            System.out.println("Bot: I'm not using " + i);
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        System.out.println("Bot: I'm stopping the other player from winning.");
                        return i;
                    }
                }
            }
        }

        System.out.println("Bot: There's nothing I can do here. Picking a random number.");
        return rand.nextInt(maxTake) + 1;
    }
}
