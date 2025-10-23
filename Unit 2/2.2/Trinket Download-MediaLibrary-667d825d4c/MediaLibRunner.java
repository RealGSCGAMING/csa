/*
 * Activity 2.2.7
 * 
 * The runner for the MediaLib program
 */

import java.util.Scanner;

public class MediaLibRunner {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String userInput;
    System.out.println("Creating...");
    MediaLib myLib = new MediaLib();
    System.out.println("\nWelcome to your Media Library!");

    while (true) {
      System.out.println("\nEnter media type, or type H for help.");
      userInput = sc.nextLine();

      // help
      if (userInput.toLowerCase().equals("h")) {
        System.out.println(
            "\nYou can have a book (B), movie (M), or song (S) in your media library. You can also view your full library with V. Press Q to quit.");
      }

      // quit
      if (userInput.toLowerCase().equals("q")) {
        break;
      }

      // full library
      if (userInput.toLowerCase().equals("v")) {
        if (!(myLib.getBook() == null && myLib.getMovie() == null && myLib.getSong() == null)) {
          System.out.println("\nYour media library:");
          System.out.println(myLib);
        } else {
          System.out.println("\nYou don't have anything to display.");
        }

      }

      // book
      if (userInput.toLowerCase().equals("b")) {

        // if no book
        if (myLib.getBook() == null) {
          System.out.println("\nYou don't have a book. Would you like to add one? (Y/N)");

          // add book if Y
          if (sc.nextLine().toLowerCase().equals("y")) {

            System.out.println("Enter your book's title.");
            String title = sc.nextLine();

            System.out.println("Enter the author of your book.");
            String author = sc.nextLine();

            Book newBook = new Book(title, author);
            myLib.addBook(newBook);
            System.out.println("\nBook added: " + myLib.getBook());
          }

          // otherwise, cancel
        }

        // if there is already a book
        else {

          System.out.println("\nYour book: " + myLib.getBook());

          while (true) {
            System.out.println("\n(BOOK) What would you like to modify? (Press H for help or X to return.)");
            userInput = sc.nextLine();

            // help
            if (userInput.toLowerCase().equals("h")) {
              System.out.println(
                  "\nYou can change the title (T), author (A), or rating (R). You can also remove your book with C.");
            }

            // back
            if (userInput.toLowerCase().equals("x")) {
              break;
            }

            if (userInput.toLowerCase().equals("c")) {
              myLib.clearBook();
              System.out.println("\nBook removed.");
              break;
            }

            // change title
            if (userInput.toLowerCase().equals("t")) {
              System.out.println("Enter new title:");
              String newTitle = sc.nextLine();
              myLib.getBook().setTitle(newTitle);
              System.out.println("\nNew book: " + myLib.getBook());
            }

            // change author
            if (userInput.toLowerCase().equals("a")) {
              System.out.println("Enter new author:");
              String newAuthor = sc.nextLine();
              myLib.getBook().setAuthor(newAuthor);
              System.out.println("\nNew book: " + myLib.getBook());
            }

            // change rating
            if (userInput.toLowerCase().equals("r")) {
              System.out.println("Enter new rating:");

              // make sure it's a valid integer
              while (true) {
                try {
                  int newRating = Integer.valueOf(sc.nextLine());
                  myLib.getBook().adjustRating(newRating);
                  System.out.println("\nNew book: " + myLib.getBook());
                  break;
                } catch (Exception e) {
                  System.out.println("Rating must be an integer from 1-10.");
                }
              }
            }
          }
        }
      }

      // movie
      if (userInput.toLowerCase().equals("m")) {

        // if no movie
        if (myLib.getMovie() == null) {
          System.out.println("\nYou don't have a movie. Would you like to add one? (Y/N)");

          // add movie if Y
          if (sc.nextLine().toLowerCase().equals("y")) {

            System.out.println("Enter your movie's title.");
            String title = sc.nextLine();

            System.out.println("Enter the duration of your movie in hours.");
            double duration = 0;

            // make sure it's a number
            while (true) {
              try {
                duration = Double.valueOf(sc.nextLine());
                break;
              } catch (Exception e) {
                System.out.println("Duration must be a number.");
              }
            }
            Movie newMovie = new Movie(title, duration);
            myLib.addMovie(newMovie);
            System.out.println("\nMovie added: " + myLib.getMovie());
          }

          // otherwise, cancel
        }

        // if there is already a movie
        else {

          System.out.println("\nYour movie: " + myLib.getMovie());

          while (true) {
            System.out.println("\n(MOVIE) What would you like to modify? (Press H for help or X to return.)");
            userInput = sc.nextLine();

            // help
            if (userInput.toLowerCase().equals("h")) {
              System.out.println(
                  "\nYou can change the title (T), duration (D), or rating (R). You can also remove your movie with C.");
            }

            // back
            if (userInput.toLowerCase().equals("x")) {
              break;
            }

            if (userInput.toLowerCase().equals("c")) {
              myLib.clearMovie();
              System.out.println("\nMovie removed.");
              break;
            }

            // change title
            if (userInput.toLowerCase().equals("t")) {
              System.out.println("Enter new title:");
              String newTitle = sc.nextLine();
              myLib.getMovie().setTitle(newTitle);
              System.out.println("\nNew movie: " + myLib.getMovie());
            }

            // change author
            if (userInput.toLowerCase().equals("d")) {
              System.out.println("Enter new duration:");
              double newDuration = 0;

              // make sure it's a number
              while (true) {
                try {
                  newDuration = Double.valueOf(sc.nextLine());
                  break;
                } catch (Exception e) {
                  System.out.println("Duration must be a number.");
                }
              }

              myLib.getMovie().setDuration(newDuration);
              System.out.println("\nNew movie: " + myLib.getMovie());
            }

            // change rating
            if (userInput.toLowerCase().equals("r")) {
              System.out.println("Enter new rating:");

              // make sure it's a valid integer
              while (true) {
                try {
                  int newRating = Integer.valueOf(sc.nextLine());
                  myLib.getMovie().adjustRating(newRating);
                  System.out.println("\nNew movie: " + myLib.getMovie());
                  break;
                } catch (Exception e) {
                  System.out.println("Rating must be an integer from 1-10.");
                }
              }
            }
          }
        }
      }

      // song
      if (userInput.toLowerCase().equals("s")) {

        // if no song
        if (myLib.getSong() == null) {
          System.out.println("\nYou don't have a song. Would you like to add one? (Y/N)");

          // add song if Y
          if (sc.nextLine().toLowerCase().equals("y")) {

            System.out.println("Enter your song's title.");
            String title = sc.nextLine();

            System.out.println("Enter the duration of your song in minutes.");
            double duration = 0;

            // make sure it's a number
            while (true) {
              try {
                duration = Double.valueOf(sc.nextLine());
                break;
              } catch (Exception e) {
                System.out.println("Duration must be a number.");
              }
            }
            Song newSong = new Song(title, duration);
            myLib.addSong(newSong);
            System.out.println("\nSong added: " + myLib.getSong());
          }

          // otherwise, cancel
        }

        // if there is already a song
        else {

          System.out.println("\nYour song: " + myLib.getSong());

          while (true) {
            System.out.println("\n(SONG) What would you like to modify? (Press H for help or X to return.)");
            userInput = sc.nextLine();

            // help
            if (userInput.toLowerCase().equals("h")) {
              System.out.println(
                  "\nYou can change the title (T), duration (D), or rating (R). You can also remove your song with C.");
            }

            // back
            if (userInput.toLowerCase().equals("x")) {
              break;
            }

            if (userInput.toLowerCase().equals("c")) {
              myLib.clearSong();
              System.out.println("\nSong removed.");
              break;
            }

            // change title
            if (userInput.toLowerCase().equals("t")) {
              System.out.println("Enter new title:");
              String newTitle = sc.nextLine();
              myLib.getSong().setTitle(newTitle);
              System.out.println("\nNew song: " + myLib.getSong());
            }

            // change author
            if (userInput.toLowerCase().equals("d")) {
              System.out.println("Enter new duration:");
              double newDuration = 0;

              // make sure it's a number
              while (true) {
                try {
                  newDuration = Double.valueOf(sc.nextLine());
                  break;
                } catch (Exception e) {
                  System.out.println("Duration must be a number.");
                }
              }

              myLib.getSong().setDuration(newDuration);
              System.out.println("\nNew song: " + myLib.getSong());
            }

            // change rating
            if (userInput.toLowerCase().equals("r")) {
              System.out.println("Enter new rating:");

              // make sure it's a valid integer
              while (true) {
                try {
                  int newRating = Integer.valueOf(sc.nextLine());
                  myLib.getSong().adjustRating(newRating);
                  System.out.println("\nNew song: " + myLib.getSong());
                  break;
                } catch (Exception e) {
                  System.out.println("Rating must be an integer from 1-10.");
                }
              }
            }
          }
        }
      }
    }

    System.out.println("\nGoodbye!");
    sc.close();

    // PLTW CODE BELOW

    /*
     * System.out.println("Welcome to your Media Library");
     * MediaLib myLib = new MediaLib();
     * 
     * Book myBook = new Book("The Lord of the Rings", "Tolkien");
     * System.out.println("Book created: " + myBook);
     * 
     * myLib.addBook(myBook);
     * 
     * System.out.println("Library:\n" + myLib);
     * 
     * int myRating = 9;
     * myBook.adjustRating(myRating);
     * System.out.println(myBook);
     * 
     * /*
     * myBook.setTitle("Hi");
     * System.out.println(myBook);
     * System.out.println("Library:\n" + myLib);
     * /
     * 
     * Book currBook = myLib.getBook();
     * // currBook.setTitle("My Favorite Book");
     * System.out.println("Current book: " + currBook);
     * 
     * System.out.println(myLib);
     * 
     * System.out.println("\n\n\n");
     * 
     * System.out.println("You have a NEW Library");
     * MediaLib myLib2 = new MediaLib();
     * 
     * Book newBook = new Book("To Kill a Mockingbird", "Lee");
     * myLib2.addBook(newBook);
     * System.out.println(myLib2);
     * newBook = new Book("1984", "Orwell");
     * System.out.println(myLib2);
     * 
     * /*System.out.println("before test:" + newBook);
     * myLib.testBook(newBook);
     * System.out.println("after test:" + newBook); * /
     * 
     * Book newBook2 = new Book("1984", "Orwell");
     * System.out.println(newBook.equals(newBook2));
     * 
     * //System.out.println(newBook2.title);
     * 
     * Movie newMovie = new Movie("The Movie", 1.75);
     * System.out.println(newMovie);
     * Movie newMovie2 = new Movie("The Movie 2", 2.10);
     * System.out.println(newMovie.equals(newMovie2));
     * myLib.addMovie(newMovie2);
     * 
     * System.out.println(myLib);
     */

    /*
     * System.out.println(MediaLib.getOwner() + "'s Library");
     * 
     * MediaLib.changeOwner("Me");
     * 
     * MediaLib.owner = "You";
     * 
     * System.out.println(MediaLib.owner);
     * 
     * System.out.println(MediaLib.getNumEntries());
     * 
     * MediaLib library = new MediaLib();
     * 
     * Book b = new Book("Book 1", "Mr. Author");
     * 
     * Movie m = new Movie("Book 1: The Movie", 7);
     * 
     * library.addBook(b);
     * 
     * System.out.println(MediaLib.getNumEntries());
     * 
     * library.addMovie(m);
     * 
     * System.out.println(MediaLib.getNumEntries());
     * 
     * Song song = new Song("Song", 3.5);
     * 
     * song.adjustRating(6);
     * 
     * library.addSong(song);
     * 
     * System.out.println(library);
     * 
     * Song song2 = new Song("Song", 3.5);
     * 
     * System.out.println(song.equals(song2));
     * 
     * System.out.println(MediaLib.getNumSongs());
     */

    /*
     * MediaLib myLib = new MediaLib();
     * myLib.addMovie(new Movie("Raiders of the Lost Ark", 1.9));
     * myLib.addBook(new Book("1984", "Orwell"));
     * myLib.addSong(new Song("In Your Eyes", 1.0));
     * System.out.println(MediaLib.getOwner() + "'s Library:\n" + myLib);
     * 
     * Book book = new Book("Book 4", "The");
     * book.adjustRating(0);
     * book.adjustRating(9);
     */

  }
}