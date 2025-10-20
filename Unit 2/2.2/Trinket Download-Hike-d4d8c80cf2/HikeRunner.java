/*
 * Activity 2.2.5
 */
public class HikeRunner
{
  public static void main(String[] args)
  {
    Hike hike1 = new Hike("Sharp Top", 3.3, 1253);
    System.out.println(hike1);
    Hike hike2 = new Hike("Apple Orchard", 2.6, 1003);
    System.out.println(hike2);
    Hike hike3 = new Hike("Hi");
    System.out.println(hike3);
    Hike hike4 = new Hike("Hike1412212", 67);
    System.out.println(hike4);

    System.out.println("First hike longer? " + hike1.isLongerThan(hike2));
    System.out.println("First hike higher? " + hike1.isHigherThan(hike2));

    System.out.println(hike1.getChallenging(hike2));
  }
}