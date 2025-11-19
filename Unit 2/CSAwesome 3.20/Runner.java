import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    // global variables
    public static LocalDate currentDate = LocalDate.now();
    static ArrayList<Movie> movies = new ArrayList<Movie>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // starter movies
        movies.add(new Movie("Movie 1", LocalDate.of(2010, 10, 15), "Person", 99, 8.56));
        movies.add(new Movie("Movie 2"));

        while (true) {

            // show main menu
            clearConsole();
            System.out.println("-- Movies --");
            printMovieList();
            System.out.println("\nWhich movie would you like to view?");

            // process input
            int input = getNumberInput(1, movies.size() + 2);
            if (input == movies.size() + 1) {
                addNewMovie();
                continue;
            }
            if (input == movies.size() + 2) {
                break;
            }

            while (true) {

                // show movie page
                clearConsole();
                try {
                    printMovieInfo(input - 1);
                } catch (Exception e) {
                    break;
                }
                System.out.println("\nPress enter to go back, or press E to edit");

                // process input
                if (sc.nextLine().toLowerCase().equals("e")) {
                    editMovie(input);
                }
                else {
                    break;
                }
            }
        }

        // clean up
        sc.close();
        clearConsole();

    }

    // prints a list of the movie titles
    public static void printMovieList() {

        // print the title of each movie
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + movies.get(i).getTitle());
        }

        // print extra menu options
        System.out.println("[" + (movies.size() + 1) + "] { Add New Movie }\n[" + (movies.size() + 2) + "] { Quit }");
    }

    // prints the movie's at the index's information using toString
    public static void printMovieInfo(int m) {
        System.out.println(movies.get(m));
    }

    // clears the console
    public static void clearConsole() {
        System.out.print("\033\143");
    }

    // gets an integer input from low to high
    public static int getNumberInput(int low, int high) {
        while (true) {
            try {
                int i = Integer.valueOf(sc.nextLine());
                if (i < low || i > high) {
                    throw new IndexOutOfBoundsException("Invalid input");
                }
                return i;
            } catch (Exception e) {
                System.out.println("Enter an integer from " + low + " to " + high);
            }
        }
    }

    // creates a new movie object from user input (title only)
    public static void addNewMovie() {

        // only asks for the title initially, user can edit other fields in the edit menu
        clearConsole();
        System.out.println("Enter movie title");
        String nTitle = sc.nextLine();
        Movie nM = new Movie(nTitle);
        movies.add(nM);
        System.out.println("Movie added! Press enter to return to the menu");
        sc.nextLine();
    }

    // allows the user to edit the movie's properties or delete it
    public static void editMovie(int input) {

        clearConsole();

        Movie editMovie = movies.get(input - 1);
        int input2;

        while (true) {

            // show edit page
            System.out.println(
                    "Which field would you like to edit?\n[1] Title\n[2] Director\n[3] Rating\n[4] Release Date\n[5] Income\n[6] { DELETE MOVIE }\n[7] { Save and Exit }");

            input2 = getNumberInput(1, 7);

            // save and exit
            if (input2 == 7) {
                break;
            }

            // delete movie
            else if (input2 == 6) {
                System.out.println("Are you sure you want to delete this movie? (Y/N)");
                if (sc.nextLine().toLowerCase().equals("y")) {
                    movies.remove(input - 1);
                    System.out.println("Movie removed. Press enter to continue.");
                    sc.nextLine();
                    break;
                } else {
                    clearConsole();
                    continue;
                }
            }

            // edit title
            else if (input2 == 1) {
                System.out.println("Enter new title.");
                editMovie.setTitle(sc.nextLine());
            }

            // edit director
            else if (input2 == 2) {
                System.out.println("Enter new director.");
                editMovie.setDirector(sc.nextLine());
            }

            // edit rating
            else if (input2 == 3) {
                System.out.println("Enter new rating.");
                editMovie.setRating(getNumberInput(0, 100));
            }

            // edit release date (asks for month, day, year)
            else if (input2 == 4) {
                System.out.println("Enter release year");
                int d1 = getNumberInput(1900, 2100);
                System.out.println("Enter release month");
                int d2 = getNumberInput(1, 12);
                System.out.println("Enter release day");
                int d3 = getNumberInput(1, 30);
                editMovie.setReleaseDate(LocalDate.of(d1, d2, d3));
            }

            // edit income (only if the movie is released)
            else if (input2 == 5) {
                if (!editMovie.isReleased()) {
                    System.out.println("Cannot set the income for an unreleased movie. (Press enter to continue)");
                    sc.nextLine();
                    clearConsole();
                    continue;
                } else {
                    System.out.println("Enter new income. (in millions)");
                    while (true) {
                        try {
                            double i = Double.valueOf(sc.nextLine());
                            editMovie.setIncome(i);
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a positive number.");
                        }
                    }
                }
            }

            // updated message and reset
            System.out.println("Updated! Press enter to continue");
            sc.nextLine();
            clearConsole();
        }
    }
}
