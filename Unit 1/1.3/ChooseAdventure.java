import java.util.Scanner;

public class ChooseAdventure {

    // create a scanner that can be used by all methods
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // welcome message
        story("\n\n\n\n\n\n\n\n\n\n\nWelcome to Village Adventure.\n[Press ENTER to continue]");

        int userInput;

        // loop for multiple playthroughs
        while (true) {

            // introduction to story
            story("You wake up in a house that you've never seen before. Confused, you get up and look around. The house is a small brick cabin with nothing but a bed, window, and door. You take a look outside and see a large forest to your left and a village to your right.");

            // get an input
            userInput = ask("Go towards the village", "Go into the forest");

            if (userInput == 1) { // village

                story("You arrive at the village and notice people stationed around the edges. You ask them what's going on, and they explain that a monster has been attacking the village. You decide to help the villagers defeat the monster, but you soon realize that you have no idea how to help.");

                // multiple paths can be selected here
                while (true) {
                    userInput = ask("Go to the Town Square", "Go to the Market", "Go to the Weapons Shop");

                    if (userInput == 1) { // town square
                        story("You walk around the town square. As you reach the other side, you notice a golden coin on the ground. You pick up the coin.");
                        break;
                    }
                    if (userInput == 2) { // market
                        story("You walk through the market. There are shops selling all sorts of foods and items, but you don't have any money.");
                    }
                    if (userInput == 3) { // weapons shop
                        story("You enter the weapons shop and see many different types of swords and axes. The shopkeeper eyes you as you look around. You want to buy a sword, but you don't have any money.");
                    }
                }

                // after coin has been picked up

                int itemBought;
                // multiple paths can be selected here
                while (true) {
                    userInput = ask("Go to the Market", "Go to the Weapons Shop");

                    if (userInput == 1) { // market
                        story("You walk through the market. There are shops selling all sorts of foods and items. You stop at a stand selling charms and eye one that claims to repel monsters.");
                        userInput = ask("Buy the charm", "Look somewhere else");
                        if (userInput == 1) { // buy item
                            story("You buy the charm.");
                            itemBought = 1;
                            break;
                        }
                    } else if (userInput == 2) { // weapons shop
                        story("You enter the weapons shop and see many different types of swords and axes. The shopkeeper eyes you as you look around. As you finish looking at every item in the store, you realize that the only thing you can buy with your coin is an old rusty sword.");
                        userInput = ask("Buy the sword", "Look somewhere else");
                        if (userInput == 1) { // buy item
                            story("You buy the sword.");
                            itemBought = 2;
                            break;
                        }
                    }
                }

                // after an item has been bought

                if (itemBought == 1) { // using charm to fight
                    story("You leave the village and head towards the forest to repel the monster with the charm. You sneak up on the monster and hold out the charm, but nothing happens. You try to run away, but the monster hears you and eats you.");
                    userInput = end();

                    if (userInput == 2) {
                        // end the game if user doesn't want to play again
                        break;
                    }
                } else if (itemBought == 2) { // using sword to fight
                    story("You leave the village and head towards the forest to fight the monster with the sword. You sneak up on the monster and swing the sword, and by some miracle it works! The monster falls to the ground in defeat. You return to the village with the news, and the villagers celebrate.");
                    story("You win! Thanks for playing!");
                    break;
                }

            } else if (userInput == 2) { // forest (in initial selection)

                story("You wander into the forest and quickly get lost. Suddenly, you hear a noise coming from behind you. Before you can react, a monster jumps out and eats you.");
                userInput = end();

                if (userInput == 2) {
                    // end the game if user doesn't want to play again
                    break;
                }
            }

        }

        // close scanner at the end
        sc.close();
    }

    // ask for input
    public static int ask(String option1, String option2) {

        // display options
        System.out.println("What would you like to do?");

        System.out.println("A: " + option1);
        System.out.println("B: " + option2);

        String userInput;

        // loop for invalid inputs
        while (true) {

            // get input
            userInput = sc.nextLine();

            // check for valid input and return selected one
            if (userInput.toUpperCase().equals("A")) {
                return 1;
            } else if (userInput.toUpperCase().equals("B")) {
                return 2;
            }

            // if the input is invalid the loop will repeat
        }

    }

    // same thing but with 3 inputs instead of 2
    public static int ask(String option1, String option2, String option3) {

        // display options
        System.out.println("What would you like to do?");

        System.out.println("A: " + option1);
        System.out.println("B: " + option2);
        System.out.println("C: " + option3);

        String userInput;

        // loop for invalid inputs
        while (true) {

            // get input
            userInput = sc.nextLine();

            // check for valid input and return selected one
            if (userInput.toUpperCase().equals("A")) {
                return 1;
            } else if (userInput.toUpperCase().equals("B")) {
                return 2;
            } else if (userInput.toUpperCase().equals("C")) {
                return 3;
            }

            // if the input is invalid the loop will repeat
        }

    }

    // display a story
    public static void story(String s) {

        System.out.println("\n");
        System.out.println(s);

        // wait for enter key press
        sc.nextLine();

    }

    // ask if user wants to replay
    public static int end() {
        System.out.println("\nGame over!");
        System.out.println("\nWould you like to play again? (Y/N)");

        String userInput;

        // loop for invalid inputs
        while (true) {

            // get input
            userInput = sc.nextLine();

            // check for valid input and return selected one
            if (userInput.toUpperCase().equals("Y")) {
                return 1;
            } else if (userInput.toUpperCase().equals("N")) {
                return 2;
            }
        }

    }
}
