public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int curr = 1;
        int max = 1;
        int min = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int num : nums) {
            curr = num;
            int curr_max = Math.max(curr, Math.max(max * curr, min * curr));
            int curr_min = Math.min(curr, Math.min(max * curr, min * curr));

            max = curr_max;
            min = curr_min;

            maxProduct = Math.max(max, maxProduct);
        }

        return maxProduct;
    }
}
