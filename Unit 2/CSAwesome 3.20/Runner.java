import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static LocalDate currentDate = LocalDate.now();
    static ArrayList<Movie> movies = new ArrayList<Movie>();

    public static void main(String[] args) {

        movies.add(new Movie("Movie 1", LocalDate.of(2010, 10, 15), "Person", 99, 8.56));
        movies.add(new Movie("Movie 2"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            clearConsole();
            System.out.println("-- Movies --");
            printMovieList();
            System.out.println("\nWhich movie would you like to view?");
            int input;
            while (true) {
                try {
                    input = Integer.valueOf(sc.nextLine());
                    if (input < 1 || input > movies.size() + 1)
                        throw new IndexOutOfBoundsException("Wrong");
                    break;
                } catch (Exception e) {
                    System.out.println("Enter the movie's number.");
                }
            }

            if (input == movies.size() + 1)
                break;

            clearConsole();
            printMovieInfo(input - 1);
            System.out.println("\nPress enter to go back, or press E to edit");

            if (sc.nextLine().toLowerCase().equals("e")) {

                clearConsole();

                Movie editMovie = movies.get(input - 1);
                while (true) {
                    System.out.println(
                            "Which field would you like to edit?\n[1] Title\n[2] Director\n[3] Rating\n[4] Release Date\n[5] Income\n[6] { Cancel }");
                    int input2;
                    while (true) {
                        try {
                            input2 = Integer.valueOf(sc.nextLine());
                            if (input2 < 1 || input2 > 6)
                                throw new IndexOutOfBoundsException("Wrong");
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid number.");
                        }
                    }
                    if (input2 == 6) {
                        break;
                    }

                    else if (input == 1) {
                        System.out.println("Enter new title.");
                        editMovie.setTitle(sc.nextLine());
                    }

                    else if (input == 2) {
                        System.out.println("Enter new director.");
                        editMovie.setDirector(sc.nextLine());
                    }

                    else if (input == 3) {
                        System.out.println("Enter new rating.");
                        try {

                        } catch (Exception e) {
                            
                        }
                    }

                    else if (input == 5) {
                        System.out.println("Enter new director.");
                        editMovie.setDirector(sc.nextLine());
                    }
                }
            }
        }

        sc.close();
        clearConsole();

    }

    public static void printMovieList() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + movies.get(i).getTitle());
        }
        System.out.println("[" + (movies.size() + 1) + "] { Quit }");
    }

    public static void printMovieInfo(int m) {
        System.out.println(movies.get(m));
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }
}
