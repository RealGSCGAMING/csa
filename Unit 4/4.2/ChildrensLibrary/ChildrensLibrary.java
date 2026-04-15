/*
 * Activity 4.2.1
 */
import java.util.ArrayList;
import java.io.IOException;

public class ChildrensLibrary
{
  public static void main(String[] args) throws IOException
  {
    Library library = new Library();
    ArrayList<Book> childrensBooks = library.getChildrensBooks();

    String authorToFind = "L. Frank Baum";

    System.out.println("Books by " + authorToFind + ":");

    for (Book b : childrensBooks) {
      if (b.getAuthor().equals(authorToFind)) {
        System.out.println(b.getTitle());
      }
    }

    String bookToFind = "Sky Island";
    double minimumRating = 0.0;

    for (Book b : childrensBooks) {
      if (b.getTitle().equals(bookToFind)) {
        minimumRating = b.getRating();
        break;
      }
    }

    System.out.println("\nBooks with a rating higher than " + bookToFind + " (" + minimumRating + "):");

    for (Book b : childrensBooks) {
      if (b.getRating() >= minimumRating) {
        System.out.println(b.getTitle());
      }
    }

    System.out.println("\nBooks that start with \"The\":");

    for (int i = 0; i < childrensBooks.size(); i++) {
      if (childrensBooks.get(i).getTitle().substring(0, 3).equals("The")) {
        System.out.println(childrensBooks.get(i).getTitle());
      }
    }

  }
}