/*
 * Activity 2.2.7
 *
 * A Book class for the MediaLibrary program
 */
public class Book {
  private String title;
  private String author;
  private int rating;

  /*** Constructor ****/
  public Book(String t, String a) {
    title = t;
    author = a;
    rating = 0;
    // System.out.println("Adding book " + t);
  }

  /*** Accessor methods ***/
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getRating() {
    return rating;
  }

  public String toString() {
    String info = "\"" + title + "\", written by " + author;
    if (rating != 0) {
      info += ", rating is " + rating;
    }
    return info;
  }

  public boolean equals(Book b) {
    // System.out.println("Checking book " + t);
    if (this.title.equals(b.title) && this.author.equals(b.author)) {
      return true;
    } else {
      return false;
    }
  }

  /*** Mutator methods ***/
  public void setTitle(String t) {
    title = t;
  }

  public void setAuthor(String a) {
    author = a;
  }

  public void adjustRating(int r) {
    // System.out.println("Adjusting rating by " + r);
    if (r <= 10 && r >= 0) {
      rating += r;
    } else {
      throw new IndexOutOfBoundsException("Not 1-10");
    }

  }

  /*
   * public String getInfo() {
   * return "The current book information is " + info;
   * }
   */
}
