/*
 * Activity 3.1.1
 */
public class DogArray {
  public static void main(String[] args) {
    Dog[] myDogs = { new Dog("Fido"), new Dog("Rex"), new Dog("Lassie") };
    Dog[] neighborsDogs = new Dog[2];

    System.out.println("My dogs:");
    System.out.println(myDogs[0].getName());
    System.out.println(myDogs[1].getName());
    System.out.println(myDogs[2].getName());

    neighborsDogs[0] = new Dog("Spot");
    neighborsDogs[1] = new Dog("Buddy");

    System.out.println("Neighbor's dogs:");
    System.out.println(neighborsDogs[0].getName());
    System.out.println(neighborsDogs[1].getName());

    Dog[] friendsDogs = { new Dog("Lady"), new Dog("Tramp") };
    System.out.println(friendsDogs[0] + " and " + friendsDogs[1]);

    // neighborsDogs = {new Dog("Cinnamon"), new Dog("Mocha")};
    // error: array constants can only be used in initializers

    // neighborsDogs[2] = new Dog("Cocoa");
    // error: array index is out of bounds

    // neighborsDogs = new Dog[3];
    // System.out.println(neighborsDogs[0].getName()); 
    // System.out.println(neighborsDogs[1].getName()); 
    // error: array elements have not been re-initialized

    myDogs[2] = null; // gave my puppy to my neighbor!

  }
}