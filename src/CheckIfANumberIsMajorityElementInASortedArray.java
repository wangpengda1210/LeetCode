public class CheckIfANumberIsMajorityElementInASortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums.length > left + nums.length / 2 && nums[left + nums.length / 2] == target;
    }
}
