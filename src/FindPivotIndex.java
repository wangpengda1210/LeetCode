public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (prefix == total) {
                return i;
            }
            prefix += nums[i];
        }

        return -1;
    }
}
