/*
 * Project 4.1.5
 *
 * A class to manage the sentiments from the consumer lab
 */
public class Sentiment
{
  private String phrase;
  private double value;

  /**
   * The constructor for a Book. All Books require
   * a title, an author, and a rating. 
   */
  public Sentiment(String phrase, double value)
  {
    this.phrase = phrase;
    this.value = value;
  }
  
  /** 
   * Gets the phrase of the sentiment
   * 
   * @return the sentiment phrase
   * */
  public String getPhrase()
  {
    return this.phrase;
  }

    /** 
   * Gets the phrase of the sentiment
   * 
   * @return the Book's title
   * */
  public double getValue()
  {
    return this.value;
  }
    
}