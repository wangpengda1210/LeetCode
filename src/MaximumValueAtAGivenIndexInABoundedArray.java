/**
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 * <p>
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 */

public class MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int start = 1;
        int end = maxSum + 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (findMinSum(n, index, mid) > maxSum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start - 1;
    }

    private long findMinSum(int n, int index, int value) {
        long sum = value;
        int right = n - index - 1;
        int left = index;

        if (right < value) {
            // value = 5 right = 2
            sum += (long) (value - 1 + value - right) * right / 2;
        } else {
            // value = 5 right = 6
            sum += (long) value * (value - 1) / 2 + (right - value + 1);
        }

        if (left < value) {
            sum += (long) (value - 1 + value - left) * left / 2;
        } else {
            sum += (long) value * (value - 1) / 2 + (left - value + 1);
        }

        return sum;
    }
}
