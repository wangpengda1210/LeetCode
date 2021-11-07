public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[longest - 1]) {
                tails[longest] = nums[i];
                longest++;
            } else {
                int pos = findSmallestLarger(tails, nums[i], longest - 1);
                tails[pos] = nums[i];
            }
        }

        return longest;
    }

    private int findSmallestLarger(int[] nums, int find, int end) {
        int start = 0;
        while (end > start) {
            int mid = (start + end) / 2;
            if (nums[mid] >= find) {
                end = mid;
            } else  {
                start = mid + 1;
            }
        }

        return end;
    }
}
