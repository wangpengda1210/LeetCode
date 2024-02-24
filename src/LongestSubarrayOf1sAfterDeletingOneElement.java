public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int max = 0;
        boolean hasZero = false;

        while (end < nums.length) {
            if (nums[end] == 0) {
                while (hasZero) {
                    hasZero = nums[start++] == 1;
                }
                hasZero = true;
            }

            max = Math.max(max, end - start);
            end++;
        }

        return max;
    }
}
