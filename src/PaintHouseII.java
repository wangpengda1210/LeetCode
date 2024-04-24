public class PaintHouseII {
    public int minCostII(int[][] costs) {
        int min = 0;
        int secondMin = 0;
        int minIndex = 0;

        for (int[] cost : costs) {
            int currMin = Integer.MAX_VALUE;
            int currSecondMin = Integer.MAX_VALUE;
            int currMinIndex = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int curr = cost[j] + (j == minIndex ? secondMin : min);
                if (curr < currMin) {
                    currSecondMin = currMin;
                    currMin = curr;
                    currMinIndex = j;
                } else if (curr < currSecondMin) {
                    currSecondMin = curr;
                }
            }
            min = currMin;
            secondMin = currSecondMin;
            minIndex = currMinIndex;
        }

        return min;
    }
}
