public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int maxUntil = 0;

        for (int num : nums) {
            maxUntil = Math.max(num, maxUntil + num);
            maxValue = Math.max(maxValue, maxUntil);
        }

        return maxValue;
    }
}
