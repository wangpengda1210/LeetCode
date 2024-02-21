public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }

        res ^= n;
        return res;
    }
}
