import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                count++;
                coins -= cost;
            } else {
                return count;
            }
        }

        return count;
    }
}
