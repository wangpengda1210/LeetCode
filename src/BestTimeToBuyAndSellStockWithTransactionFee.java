public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int sold = 0;
        int held = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curr = held;

            held = Math.max(held, sold - prices[i]);
            sold = Math.max(sold, curr + prices[i] - fee);
        }

        return Math.max(held, sold);
    }
}
