import java.time.LocalDate;

public class Movie {
    
    private String title;
    private String director;
    private int rating;
    private LocalDate releaseDate;
    private double income;
    private boolean released;

    LocalDate tw = LocalDate.of(2005, 1, 2);
    
    // constructors
    public Movie(String t) {
        title = t;
        director = "Unknown";
        rating = (int) (Math.random() * 100);
        releaseDate = randomDate();
        released = checkIfReleased();
        income = 0;
    }

    public Movie(String t, LocalDate rd) {
        title = t;
        director = "Unknown";
        rating = (int) (Math.random() * 100);
        releaseDate = rd;
        released = checkIfReleased();
        income = 0;
    }

    public Movie(String t, LocalDate rd, String d) {
        title = t;
        director = d;
        rating = (int) (Math.random() * 100);
        releaseDate = rd;
        released = checkIfReleased();
        income = 0;
    }

    public Movie(String t, LocalDate rd, String d, int r) {
        title = t;
        director = d;
        rating = r;
        releaseDate = rd;
        released = checkIfReleased();
        income = 0;
    }

    public Movie(String t, LocalDate rd, String d, int r, double i) {
        title = t;
        director = d;
        rating = r;
        releaseDate = rd;
        released = checkIfReleased();
        income = i;
    }

    // functional methods
    
    public String dateToString() {
        return releaseDate.getMonthValue() + "/" + releaseDate.getDayOfMonth() + "/" + releaseDate.getYear();
    }

    public LocalDate randomDate() {
        return LocalDate.of((int) (Math.random() * 200) + 1900, (int) (Math.random() * 11) + 1, (int) (Math.random() * 29) + 1);
    }

    public boolean checkIfReleased() {
        if (Runner.currentDate.isAfter(releaseDate)) return true; else return false;
    }

    // get methods
    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
       return releaseDate; 
    }

    public double getIncome() {
        if (!released) {
            throw new IllegalStateException("Movie is unreleased");
        }
        return income;
    }
    public boolean isReleased() {
        return released;
    }

    // setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReleaseDate(LocalDate date) {
        this.releaseDate = date;
        released = checkIfReleased();
        if (!released) {
            income = 0.0;
        }
    }

    public void setIncome(double income) {
        if (!released) {
            throw new IllegalStateException("Cannot set income unless movie is marked as released");
        }

        if (income < 0 ) {
            throw new IllegalArgumentException("Income cannot be a negative number");
        } 
        this.income = income;
    }

    // method to mark movie as released (used when release date passes)
    
    public void markAsReleased() {
        this.released = true;
    }
    
    // toString
    
    public String toString() {
        return "-- " + title + " --\nDirector: " + director + "\nRelease Date: " + dateToString() + "\nRotten Tomatoes Rating: " + rating + (released ? "%\nGross income: $" + income + " million" : "%");
    }

    private int yearFromDate() {
        return releaseDate != null ? releaseDate.getYear() : 0;
    }

    // main method for testing

        // Output: xyz movie (year released)
        // Director: xyz director
        // Releaste date: xyz release date
        // Status: true || false released
        // Rotten Tomatoes = rating
        // Box Office = income
    
}