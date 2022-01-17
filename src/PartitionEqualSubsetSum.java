import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            boolean[] newDp = Arrays.copyOf(dp, dp.length);
            for (int i = 1; i < dp.length; i++) {
                if (i >= num) {
                    newDp[i] = dp[i] || dp[i - num];
                }
            }
            dp = newDp;
        }

        return dp[sum];
    }
}
