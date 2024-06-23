/**
 * You are given an integer array nums with length n.
 * <p>
 * The cost of a subarray nums[l..r], where 0 <= l <= r < n, is defined as:
 * <p>
 * cost(l, r) = nums[l] - nums[l + 1] + ... + nums[r] * (−1)r − l
 * <p>
 * Your task is to split nums into subarrays such that the total cost of the subarrays is maximized, ensuring each element belongs to exactly one subarray.
 * <p>
 * Formally, if nums is split into k subarrays, where k > 1, at indices i1, i2, ..., ik − 1, where 0 <= i1 < i2 < ... < ik - 1 < n - 1, then the total cost will be:
 * <p>
 * cost(0, i1) + cost(i1 + 1, i2) + ... + cost(ik − 1 + 1, n − 1)
 * <p>
 * Return an integer denoting the maximum total cost of the subarrays after splitting the array optimally.
 * <p>
 * Note: If nums is not split into subarrays, i.e. k = 1, the total cost is simply cost(0, n - 1).
 */

public class MaximizeTotalCostOfAlternatingSubarrays {
    public long maximumTotalCost(int[] nums) {
        long prevSplit = nums[0];
        long prevNonSplit = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long num = nums[i];
            long currSplit = Math.max(prevSplit, prevNonSplit) + num;
            long currNonSplit = prevSplit - num;
            prevSplit = currSplit;
            prevNonSplit = currNonSplit;
        }

        return Math.max(prevSplit, prevNonSplit);
    }
}
