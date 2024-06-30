/**
 * You are given an integer array nums and a positive integer k.
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * <p>
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
 * Return the length of the longest valid subsequence of nums.
 */

public class FindTheMaximumLengthOfValidSubsequenceII {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int maxLength = 0;

        for (int num : nums) {
            int remainder = num % k;
            for (int i = 0; i < k; i++) {
                int prev = (i - remainder + k) % k;
                dp[remainder][i] = Math.max(dp[remainder][i], dp[prev][i] + 1);
                maxLength = Math.max(dp[remainder][i], maxLength);
            }
        }

        return maxLength;
    }
}
