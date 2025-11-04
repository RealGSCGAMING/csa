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

    String dogTargets = "";
    String catTargets = "";
    String etcTargets = "";
    
    while (true) {

      String currentPost = d.getNextPost();

      // if there are no more posts end loop
      if (currentPost.equals("NONE")) break;

      while (true) {

        String currentWord = d.getNextTargetWord().toLowerCase();

        // if all words have been checked end loop
        if (currentWord.equals("none")) break;

        // check if the post contains the word and the word is not in the username
        if (currentPost.toLowerCase().indexOf(currentWord) != -1 && currentPost.toLowerCase().indexOf(currentWord) > currentPost.indexOf(" ")) {

          boolean valid = true;

          // check for words that make the post invalid (such as "hotdog")
          for (int i = 0; i < d.targetWordsNot.size(); i++) {
            
            if (currentPost.toLowerCase().indexOf(d.targetWordsNot.get(i)) != -1) {

              // Skip updating targets if post is invalid
              valid = false;

            }
          }

          // Update the target variables depending on which pet the user owns
          if (valid) {

            if (d.currentTargetWordType() == 1) {
              dogTargets = dogTargets + currentPost.substring(0, currentPost.indexOf(" ") + 1);
            }

            else if (d.currentTargetWordType() == 2) {
              catTargets = catTargets + currentPost.substring(0, currentPost.indexOf(" ") + 1);
            }

            // if it can't figure out what kind of pet
            else {
              etcTargets = etcTargets + currentPost.substring(0, currentPost.indexOf(" ") + 1);
            }
          } 

          // reset current target word for next post
          d.resetTargetWord();

          break;

        }
      }
    }

    // Reset the advertisements file
    d.clearFile("advertisement.txt");

    // Create advertisements for dog, cat, and other animal owners
    d.prepareAdvertisement("advertisement.txt", dogTargets, "Your dog will love our pet food!");
    d.prepareAdvertisement("advertisement.txt", catTargets, "Your cat will love our pet food!");
    d.prepareAdvertisement("advertisement.txt", etcTargets, "Your furry friend will love our pet food!");

    System.out.println("done");

  }
}