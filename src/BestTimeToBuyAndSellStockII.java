public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int currPrice = Integer.MAX_VALUE;
        int totalProfit = 0;

        for (int price : prices) {
            if (price > currPrice) {
                totalProfit += price - currPrice;
            }
            currPrice = price;
        }

        return totalProfit;
    }
}
