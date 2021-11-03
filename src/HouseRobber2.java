public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] values = new int[length];

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[start];
        }

        values[0] = nums[start];
        values[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < length; i++) {
            values[i] = Math.max(values[i - 2] + nums[start + i], values[i - 1]);
        }

        return values[length - 1];
    }
}
