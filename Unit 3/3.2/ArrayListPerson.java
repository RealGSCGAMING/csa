import java.util.ArrayList;
// CODE TO ADD
public class ArrayListPerson
{  
  public static void main(String[] args)
  { 
    ArrayList<Person> people = new ArrayList<Person>();

    people.add(new Person("John", 30, false));
    people.add(new Person("Jim", 15, true));
    people.add(new Person("Jack", 27, true));

    // people.add("My cousin");
    // (Error because the list's type is Person, not String)

    for (Person p : people) {
        System.out.println(p.name);
    }
  }
}

class Person {

    String name;
    int age;
    boolean isSleeping;

    public Person(String n, int a, boolean s) {
        name = n;
        age = a;
        isSleeping = s;
    }
}