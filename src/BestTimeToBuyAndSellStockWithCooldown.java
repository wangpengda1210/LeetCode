public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int cooldown = 0;

        for (int price : prices) {
            int curr = sold;

            sold = held + price;
            held = Math.max(held, cooldown - price);
            cooldown = Math.max(cooldown, curr);
        }

        return Math.max(sold, Math.max(held, cooldown));
    }
}
