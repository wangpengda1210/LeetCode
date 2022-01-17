import java.util.Arrays;

public class MinimumCostForTickets {
    int[] length = new int[] { 1, 7, 30 };

    public int mincostTickets(int[] days, int[] costs) {
        int[] minCost = new int[days.length];
        Arrays.fill(minCost, -1);

        return dp(days, costs, minCost, 0);
    }

    private int dp(int[] days, int[] costs, int[] minCost, int day) {
        if (day >= days.length) {
            return 0;
        }

        if (minCost[day] != -1) {
            return minCost[day];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int j = day;
            while (j < days.length && days[j] - days[day] < length[i]) {
                j++;
            }
            min = Math.min(min, dp(days, costs, minCost, j) + costs[i]);
        }

        minCost[day] = min;
        return min;
    }
}
