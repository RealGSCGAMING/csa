public class test {

    public static void main(String[] args) {
       String test = "I am a |great| robot.";
       int first = test.indexOf("|");
       System.out.println(first);
       int second = test.indexOf("|", test.indexOf("|", first + 1));
       System.out.println(second);
       
       String finalWord = test.substring(first + 1, second);
       int finalLength = (second + 1) - first;
       System.out.println(finalWord);
       System.out.println(finalLength);
    }
}
