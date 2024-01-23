public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            currMax = Math.max(0, currMax) + num;
            max = Math.max(max, currMax);
            currMin = Math.min(0, currMin) + num;
            min = Math.min(min, currMin);
        }

        if (sum == min) {
            return max;
        }

        return Math.max(max, sum - min);
    }
}
