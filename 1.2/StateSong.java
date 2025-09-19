// CODE TO ADD
public class StateSong
{
    public static void main(String[] args)
    {
        // string created using literal
        String string1 = "Hello";
        System.out.println(string1);

        // immutable string
        string1.concat(":)");
        System.out.println(string1);

        // implicit type conversion
        System.out.println(string1 + 4);

        // += operator
        string1 += " world!";
        System.out.println(string1);

        // + operator
        System.out.println(string1 + " :)");
    }
}