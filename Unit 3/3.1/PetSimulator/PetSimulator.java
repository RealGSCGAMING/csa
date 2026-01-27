package PetSimulator;
/*
 * Activity 3.1.3
 */
public class PetSimulator
{
  public static void main(String[] args)
  {
    // create an array that can hold up to 10 pets (does not require looping)
    Pet[] pets = new Pet[10];
    // adopt (create and name) four pets, two cats, two dogs (does not require looping)
    pets[1] = new Pet("Soup", 1);
    pets[2] = new Pet("Stew", 1);
    pets[3] = new Pet("Echo", 2);
    pets[4] = new Pet("Tango", 2);
    // first things first, feed your pets
    for (Pet p : pets) {
      if (p != null) p.feed();
    }
    // next, make yourself the owner of all of your new pets
    for (Pet p : pets) {
      if (p != null) p.setOwner("Gavin");
    }
    // your dogs make some noise, take them for a walk
    for (Pet p : pets) {
      if (p != null && p.getType() == 2) p.makeNoise();
    }
    for (Pet p : pets) {
      if (p != null && p.getType() == 2) p.walk();
    }
    // when you get back, your cats make some noise
    for (Pet p : pets) {
      if (p != null && p.getType() == 1) p.makeNoise();
    }
    // give all of your pets a treat
    for (Pet p : pets) {
      if (p != null) p.giveTreat();
    }
    // groom your cats
    for (Pet p : pets) {
      if (p != null && p.getType() == 1) p.groom();
    }
    // grooming is done, play with all pets
    for (Pet p : pets) {
      if (p != null) p.play();
    }
    // whew, that was tiring, all pets nap and get fed
    for (Pet p : pets) {
      if (p != null) p.feed();
    }
    for (Pet p : pets) {
      if (p != null) p.sleep();
    }
    System.out.println("--- MY PETS ---");
    // show the state of all of your pets
    for (Pet p : pets) {
      if (p != null) System.out.println(p);
    }
    // You decide to get a couple of pets for your friend (does not require looping)
    pets[5] = new Pet("Phoebe", 1);
    pets[6] = new Pet("Flash", 1);
    // set the owner of the new pets to your friends name
    pets[5].setOwner("Theo");
    pets[6].setOwner("Theo");
    System.out.println("--- MY PETS ---");
    // show the state of all of your pets
    for (Pet p : pets) {
      if (p != null) System.out.println(p);
    }
  }
}