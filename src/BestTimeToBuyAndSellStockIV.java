import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[] costs = new int[k];
        int[] profits = new int[k];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int price : prices) {
            costs[0] = Math.min(costs[0], price);
            profits[0] = Math.max(profits[0], price - costs[0]);
            for (int i = 1; i < k; i++) {
                costs[i] = Math.min(costs[i], price - profits[i - 1]);
                profits[i] = Math.max(profits[i], price - costs[i]);
            }
        }

        return profits[k - 1];
    }
}
