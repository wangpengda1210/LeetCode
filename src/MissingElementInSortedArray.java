public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        if (k > nums[right] - nums[left] - right) {
            return k + nums[left] + right;
        }

        while (right > left) {
            int mid = left + (right - left) / 2;
            int missing = nums[mid] - nums[0] - mid;

            if (missing >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return k + nums[0] + left - 1;
    }
}
