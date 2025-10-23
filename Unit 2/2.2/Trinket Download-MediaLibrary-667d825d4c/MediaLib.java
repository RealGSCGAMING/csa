/**
 * Activity 2.2.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib {
  private Book book;
  private Movie movie;
  private Song song;
  String lastMod;

  public void addBook(Book b) {
    if (book == null) {
      book = b;
      numEntries++;
      numBooks++;
      lastMod = Modified.getDate();
    } else {
      System.out.println("You can only add one book to your library.");
    }
  }

  public void changeBook(Book b) {
    book = b;
  }

  public void addMovie(Movie m) {
    if (movie == null) {
      movie = m;
      numEntries++;
      numMovies++;
      lastMod = Modified.getDate();
    } else {
      System.out.println("You can only add one movie to your library.");
    }
  }

  public void changeMovie(Movie m) {
    movie = m;
  }

  public void addSong(Song s) {
    if (song == null) {
      song = s;
      numEntries++;
      numSongs++;
      lastMod = Modified.getDate();
    } else {
      System.out.println("You can only add one song to your library.");
    }
  }

  public void clearBook() {
    book = null;
  }

  public void clearMovie() {
    movie = null;
  }

  public void clearSong() {
    song = null;
  }

  public String toString() {
    String info = "";

    if (book != null) {
      info = "Book: " + book.toString();
    }

    if (movie != null) {
      info = info + "\nMovie: " + movie.toString();
    }

    if (song != null) {
      info = info + "\nSong: " + song.toString();
    }

    info = info + ".\nLast modified on " + lastMod;

    return info;
  }

  public Book getBook() {
    return book;
  }

  public Movie getMovie() {
    return movie;
  }

  public Song getSong() {
    return song;
  }

  public static String owner = "PLTW";

  public static String getOwner() {
    return owner;
  }

  public static void changeOwner(String o) {
    owner = o;
  }

  private static int numEntries = 0;

  public static int getNumEntries() {
    return numEntries;
  }

  private static int numBooks = 0;
  private static int numMovies = 0;
  private static int numSongs = 0;

  public static int getNumBooks() {
    return numBooks;
  }

  public static int getNumMovies() {
    return numMovies;
  }

  public static int getNumSongs() {
    return numSongs;
  }

  /*
   * public void testBook(Book tester) {
   * tester.setTitle("New Title");
   * System.out.println(book);
   * }
   */
}