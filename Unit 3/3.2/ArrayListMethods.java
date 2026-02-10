import java.util.ArrayList;
import java.util.Scanner;

// CODE TO ADD
public class ArrayListMethods {
    public static void main(String[] args) {

        ArrayList<String> things = new ArrayList<String>();

        things.add("Dog");
        things.add("Cat");
        things.add("Rabbit");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(things);
            System.out.println("Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?");
            String input = sc.nextLine();

            if (input.equals("a")) {
                System.out.println("What would you like to add");
                things.add(sc.nextLine());
            }

            else if (input.equals("i")) {
                System.out.println("What would you like to insert");
                input = sc.nextLine();
                System.out.println("What index do you want to insert it at (indexes start at 1)");
                while (true) {
                    try {
                        things.add(Integer.parseInt(sc.nextLine()) - 1, input);
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a number between 1 and " + things.size());
                    }
                }
            }

            else if (input.equals("r")) {
                System.out.println("What index would you like to remove (indexes start at 1)");
                while (true) {
                    try {
                        things.remove(Integer.parseInt(sc.nextLine()) - 1);
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a number between 1 and " + things.size());
                    }
                }
            }

            else if (input.equals("p")) {
                System.out.println("What index would you like to replace (indexes start at 1)");
                int input2;
                while (true) {
                    try {
                        input2 = Integer.parseInt(sc.nextLine()) - 1;
                        if (input2 < 0)
                            throw new IndexOutOfBoundsException();
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a number between 1 and " + things.size());
                    }
                }

                System.out.println("What would you like to replace it with");
                things.set(input2, sc.nextLine());
            }

            else if (input.equals("q")) {
                break;
            }
        }

        sc.close();
    }
}