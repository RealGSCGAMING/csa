/**
 * Activity 2.2.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib {
  private Book book;
  private Movie movie;

  public void addBook(Book b) {
    book = b;
  }

  public void addMovie(Movie m) {
    movie = m;
  }

  public String toString() {
    String info = "";

    if (movie != null) {
      info = "Book: " + book.toString() + "\nMovie: " + movie.toString();
    }
    else {
      info = book.toString();
    }

    

    return info;
  }

  public Book getBook() {
    return book;
  }

  public Movie getMovie() {
    return movie;
  }

  /*public void testBook(Book tester) {
    tester.setTitle("New Title");
    System.out.println(book);
  }*/
}