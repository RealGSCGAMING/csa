import java.util.Scanner;

public class t {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        double currentScorePercent = 77.00 / 65.00;

        while (true) {
            String inp = sc.nextLine();
            if (inp.toLowerCase().equals("q")) {
                break;
            }

            double finalScorePercent = Double.parseDouble(inp);
            double total = (currentScorePercent * 100 + finalScorePercent) / 2.0;

            System.out.println("Grade will be: " + (total) + "%");

        }
        sc.close();
    }
}
