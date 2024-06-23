import java.util.Arrays;

/**
 * You are given an array of integers nums and an integer target.
 * <p>
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int sum = 0;

        int[] power = new int[nums.length + 1];
        power[0] = 0;
        if (nums.length > 1) {
            power[1] = 1;
        }
        for (int i = 2; i < power.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[i] + nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            sum += power[left - i];
            sum %= mod;
        }

        return sum;
    }
}
