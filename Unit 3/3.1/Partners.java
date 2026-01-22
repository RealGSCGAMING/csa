/*
 * Activity 3.1.1
 */
public class Partners
{
  public static void main(String[] args)
  {    
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    String[] partners = new String[7];

    partners[1] = "Alice";
    partners[3] = "Bob";
    partners[5] = "Charlie";

    System.out.println("Partners for the week:");
    System.out.println(days[1] + ": " + partners[1]);
    System.out.println(days[3] + ": " + partners[3]);
    System.out.println(days[5] + ": " + partners[5]);

    String[] friendPartners = partners;

    System.out.println("Friend's partners for the week:");
    System.out.println(days[1] + ": " + friendPartners[1]);
    System.out.println(days[3] + ": " + friendPartners[3]);
    System.out.println(days[5] + ": " + friendPartners[5]);

    partners[1] = "Diana";
    
    System.out.println("After changing partner on Monday:");
    System.out.println(days[1] + ": " + partners[1]);
    System.out.println(days[1] + ": " + friendPartners[1]);
  }
}

