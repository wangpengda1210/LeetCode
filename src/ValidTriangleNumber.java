import java.util.Arrays;

/**
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 */

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int start = j + 1;
                int end = nums.length;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (nums[i] + nums[j] <= nums[mid]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                count += start - j - 1;
            }
        }

        return count;
    }
}
