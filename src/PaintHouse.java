public class PaintHouse {
    public int minCost(int[][] costs) {
        int min0 = 0;
        int min1 = 0;
        int min2 = 0;

        for (int[] cost : costs) {
            int currMin0 = Math.min(min1, min2) + cost[0];
            int currMin1 = Math.min(min0, min2) + cost[1];
            int currMin2 = Math.min(min1, min0) + cost[2];
            min0 = currMin0;
            min1 = currMin1;
            min2 = currMin2;
        }

        return Math.min(min0, Math.min(min1, min2));
    }
}
