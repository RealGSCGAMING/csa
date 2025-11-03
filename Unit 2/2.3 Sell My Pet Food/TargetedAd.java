/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd {

  public static void main(String[] args)
  {
    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* your code here */


    DataCollector d = new DataCollector();
    d.setData("socialMediaPosts.txt", "targetWords.txt");

    String targets = "";
    
    while (true) {

      String currentPost = d.getNextPost();

      // if there are no more posts end loop
      if (currentPost.equals("NONE")) break;

      //System.out.println("Current post: " + currentPost);

      while (true) {

        String currentWord = d.getNextTargetWord().toLowerCase();

        // if all words have been checked end loop
        if (currentWord.equals("none")) break;

        //System.out.print("Checking word: " + currentWord + ": ");

        // if the post contains the word and the word is not in the username
        if (currentPost.toLowerCase().indexOf(currentWord) != -1 && currentPost.toLowerCase().indexOf(currentWord) > currentPost.indexOf(" ")) {

          //System.out.println("true");

          boolean valid = true;

          // check for words that make the post invalid
          for (int i = 0; i < d.targetWordsNot.size(); i++) {
            if (currentPost.toLowerCase().indexOf(d.targetWordsNot.get(i)) != -1) {
              valid = false;
            }
          }

          // update targets variable with new user separated by spaces
          if (valid) targets = targets + currentPost.substring(0, currentPost.indexOf(" ") + 1);
          
          //System.out.println("Targets: " + targets);

          // reset current target word for next post
          d.resetTargetWord();

          break;

        }
      }
    }

    System.out.println(targets);

    d.prepareAdvertisement("advertisement.txt", targets, "This is a targeted ad.");

  }

}
