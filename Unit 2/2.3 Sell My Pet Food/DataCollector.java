/*
 * Problem 2.3.1 Sell My Pet Food
 * 
 * V1.0
 * 6/1/2019
 * Copyright(c) 2019 PLTW to present. All rights reserved
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

/**
 * A DataCollector class to manage social media posts
 */
public class DataCollector
{
  private ArrayList<String> socialMediaPosts;
  private ArrayList<String> targetWords;
  public ArrayList<String> targetWordsNot;
  private Scanner sc;
  private int currentPost;
  private int currentTargetWord;

  public DataCollector()
  {
    socialMediaPosts = new ArrayList<String>();
    targetWords = new ArrayList<String>();
    targetWordsNot = new ArrayList<String>();
    currentPost = 0;
    currentTargetWord = 0;
  }

  /**
   * Gather the data contained in the files socialMediaPostsFilename and
   * targetWordsFilename (including punctuation), with words separated by a single
   * space
   * 
   * @param socialMediaPostsFilename the name of the file containing social media posts
   * @param targetWordsFilename the name of the file containing the target words
   */
  public void setData(String socialMediaPostsFilename, String targetWordsFilename) {
    // read in the social media posts found in socialMediaPosts
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      sc = new Scanner(new File(socialMediaPostsFilename));
      while (sc.hasNextLine())
      {
        // String method trim removes whitespace before and after a string
        String temp = sc.nextLine().trim();
        // DEBUG: System.out.println(temp);
        this.socialMediaPosts.add(temp);
      }
    } catch (Exception e) { System.out.println("Error reading or parsing" + socialMediaPosts + "\n" + e); }

    // read in the target words in targetWords
    try
    {
      sc = new Scanner(new File(targetWordsFilename));
      while (sc.hasNextLine())
      {
        // String method trim removes whitespace before and after a string
        String add = sc.nextLine().trim();

        // check if the word is negative
        if (add.indexOf("-") == -1) {
          this.targetWords.add(add);
        }
        else {
          this.targetWordsNot.add(add.substring(1));
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing" + targetWords + "\n" + e); }
  }

  /**
   * Get the next post in socialMediaPosts with words separated by a single space, 
   * or "NONE" if there is no more data.
   * 
   * @return a string containing one of the lines in socialMediaPosts
   */
  public String getNextPost()
  {
    if (currentPost < socialMediaPosts.size())
    {
      this.currentPost++;
      return socialMediaPosts.get(currentPost - 1);
    }
    else
    {
      return "NONE";
    }
  }

  /**
   * Get the next line in targetWords, with words separated by a space,
   * or "NONE" if there is no more data.
   * 
   * @return a string containing one of the lines in targetWords
   */
  public String getNextTargetWord()
  {
    if (currentTargetWord < targetWords.size())
    {
      this.currentTargetWord++;
      return targetWords.get(currentTargetWord - 1).substring(1);
    }
    else
    {
      this.currentTargetWord = 0;
      return "NONE";
    }
  }

  // Returns the target of the current target word (cat,dog,etc)
  public int currentTargetWordType() {
    return Integer.valueOf(targetWords.get(currentTargetWord - 1).substring(0,1));
  }

  /**
   * Create a File named filename and stores all the usernames to target
   * 
   * @param filename The name to save the file, must include .txt
   * @param usernames A string containing the usernames of people to target,
   * usernames are separated by a space.
   */
  public void prepareAdvertisement(String filename, String usernames, String advertisement)
  {
    try
    {
      FileWriter fw = new FileWriter(filename, true);
      // Strin method split splits a string based on the provided token
      // and returns an array of individual substrings
      for (String un : usernames.split(" "))
      {
          fw.write("@" + un + " " + advertisement +"\n");
      }
      fw.close();
    }
    catch (IOException e)
    {
        System.out.println("Could not write to file. " + e);
    }
  }

  // Clears the file at filename
  public void clearFile(String filename) {
    try
    {
      FileWriter fw = new FileWriter(filename);
      fw.write("");
      fw.close();
    }
    catch (IOException e)
    {
        System.out.println("Could not write to file. " + e);
    }
  }

  /**
   * Print the array of posts
   */
  public void printAllPosts()
  {
    for (String post : this.socialMediaPosts)
      System.out.println(post);
  }

  /**
   * Print the array of target words
   */
  public void printAllTargetWords()
  {
    for (String word : this.targetWords)
      System.out.println(word);
  }


  /**
   * Resets the current post to 0
   */
  public void resetCurrentPost() {
    currentPost = 0;
  }

  /**
   * Resets the current target word to 0
   */
  public void resetTargetWord() {
    currentTargetWord = 0;
  }

  public class SellMyPetFood {
    public static void main(String[] args) {
      DataCollector dc = new DataCollector();

      dc.setData("socialMediaPosts.txt", "targetWords.txt");

      String usernames = findTargetedUsers(dc);

      String ad = "Want the highest Quality Pet Food? Try Royal Canin's Premium Pet Food today!";

      dc.prepareAdvertisement("targeted_ads.txt", usernames, ad);

      System.out.println("Advertisements ready in targeted_ads.txt");

    }
  }

  public static String findTargetedUsers(DataCollector dc) {
    StringBuilder usernames = new StringBuilder();
    java.util.HashSet<String> seen = new java.util.HashSet<>();
    String post = dc.getNextPost();

    dc.resetCurrentPost();

    while (!post.equals("NONE")) {
      boolean matches = false;
      String word = dc.getNextTargetWord();
      
      
      while (!word.equals("NONE") && !matches) {
        if (post.toLowerCase().contains(word.toLowerCase())) {
          matches = true;

        }
        word = dc.getNextTargetWord();

      }

      if (matches) {
        String username = extractUsername(post);
        if (username != null && seen.add(username)) {
          usernames.append(username).append(" ");
        }
      }

      post = dc.getNextPost();
    }
  

  return usernames.toString().trim();
}

  private static String extractUsername(String post) {
    if (post == null || !post.startsWith("@")) return null;
    int space = post.indexOf(' ');
    return (space > 1) ? post.substring(1, space) : null;
  }

  public static void main(String[] args) {
    DataCollector dc = new DataCollector();
    dc.setData("socialMediaPosts.txt", "targetWords.txt");

    String users = findTargetedUsers(dc);
    dc.prepareAdvertisement("targeted_ads.txt", users, "Love your pet? Try PetJoy Food!");
    System.out.println("Done - check targeted_ads.txt");

  }
} 