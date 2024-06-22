/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 */

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 != 1) {
                mid--;
            }
            if (nums[mid] != nums[mid - 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }

        return nums[start - 1];
    }
}
