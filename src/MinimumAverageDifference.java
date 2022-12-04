public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int minIndex = -1;
        int minAvg = Integer.MAX_VALUE;
        long currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            totalSum -= nums[i];

            long avgDiff = currSum / (i + 1);
            if (nums.length - i - 1 != 0) {
                avgDiff = Math.abs(avgDiff - totalSum / (nums.length - i - 1));
            }

            if (avgDiff < minAvg) {
                minIndex = i;
                minAvg = (int) avgDiff;
            }
        }

        return minIndex;
    }
}
