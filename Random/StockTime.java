public class StockTime {
    public static void main(String[] args) {

        int[] nums = {7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            int thisProfit = prices[i] - buyPrice;

            if (thisProfit > maxProfit) {
                maxProfit = thisProfit;
            }

        }

        return maxProfit;

    }
}
