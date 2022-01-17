public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;

        int profit1 = 0;
        int profit2 = 0;

        for (int price : prices) {
            cost1 = Math.min(cost1, price);
            profit1 = Math.max(profit1, price - cost1);

            cost2 = Math.min(cost2, price - profit1);
            profit2 = Math.max(profit2, price - cost2);
        }

        return profit2;
    }
}
