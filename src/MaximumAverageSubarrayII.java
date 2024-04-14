public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while (right - left > 0.00001) {
            double mid = left + (right - left) / 2;

            if (check(mid, nums, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean check(double mid, int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }

        if (sum >= 0) {
            return true;
        }

        double prev = 0;
        double prevMin = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;

            prevMin = Math.min(prevMin, prev);
            if (sum - prevMin >= 0) {
                return true;
            }
        }

        return false;
    }
}
