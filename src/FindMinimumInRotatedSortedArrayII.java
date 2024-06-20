/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 */

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                end = mid;
            } else if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                start++;
            }
        }

        return nums[start];
    }
}
