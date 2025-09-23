public class WhileAndFor
{
  public static void main(String[] args)
  {
    int i = -10;
    while (i <= 10)
    {
      System.out.println(i);
      i += 1;
    }
    for (i = -10; i <= 10; i++) {
        System.out.println(i);
    }
    for (i = 0; i <= 50; i+=5) {
        System.out.println(i);
    }
  }
}