public class Song {
    private String title;
    private double duration;
    private int rating;
  
    /*** Constructor ****/
    public Song(String t, double d) {
      title = t;
      duration = d;
      rating = 0;
    }
  
    /*** Accessor methods ***/
    public String getTitle() {
      return title;
    }
  
    public double getDuration() {
      return duration;
    }
  
    public int getRating() {
      return rating;
    }
  
    public String toString() {
      String info = "\"" + title + "\", " + duration + " minutes long";
      if (rating != 0) {
        info += ", rating is " + rating;
      }
      return info;
    }
  
    public boolean equals(Song s) {
      if (this.title.equals(s.title) && this.duration == s.duration) {
        return true;
      } 
      else {
        return false;
      }
    }
  
    /*** Mutator methods ***/
    public void setTitle(String t) {
      title = t;
    }
  
    public void setDuration(double d) {
      duration = d;
    }
  
    public void adjustRating(int r) {
      if (r <= 10 && r >= 0) {
        rating += r;
      }
  
    }
  }
  