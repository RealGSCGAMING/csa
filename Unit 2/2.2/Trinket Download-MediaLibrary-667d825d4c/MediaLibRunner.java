/*
 * Activity 2.2.7
 * 
 * The runner for the MediaLib program
 */
public class MediaLibRunner {
  public static void main(String[] args) {
    System.out.println("Welcome to your Media Library");
    MediaLib myLib = new MediaLib();

    Book myBook = new Book("The Lord of the Rings", "Tolkien");
    System.out.println("Book created: " + myBook);

    myLib.addBook(myBook);

    System.out.println("Library:\n" + myLib);

    int myRating = 9;
    myBook.adjustRating(myRating);
    System.out.println(myBook);

    /*
     * myBook.setTitle("Hi");
     * System.out.println(myBook);
     * System.out.println("Library:\n" + myLib);
     */

    Book currBook = myLib.getBook();
    // currBook.setTitle("My Favorite Book");
    System.out.println("Current book: " + currBook);

    System.out.println(myLib);

    System.out.println("\n\n\n");

    System.out.println("You have a NEW Library");
    MediaLib myLib2 = new MediaLib();

    Book newBook = new Book("To Kill a Mockingbird", "Lee");
    myLib2.addBook(newBook);
    System.out.println(myLib2);
    newBook = new Book("1984", "Orwell");
    System.out.println(myLib2);

    /*System.out.println("before test:" + newBook);
    myLib.testBook(newBook);
    System.out.println("after test:" + newBook);*/

    Book newBook2 = new Book("1984", "Orwell");
    System.out.println(newBook.equals(newBook2));

    //System.out.println(newBook2.title);

    Movie newMovie = new Movie("The Movie", 1.75);
    System.out.println(newMovie);
    Movie newMovie2 = new Movie("The Movie 2", 2.10);
    System.out.println(newMovie.equals(newMovie2));
    myLib.addMovie(newMovie2);

    System.out.println(myLib);

  }
}