/**
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
 * divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * <p>
 * Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * <p>
 * The test cases are generated so that there will be an answer.
 */

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1;
        for (int num : nums) {
            end = Math.max(end, num);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (division(nums, mid) <= threshold) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private long division(int[] nums, int divisor) {
        long sum = 0;
        for (int num : nums) {
            sum += num % divisor == 0 ? num / divisor : num / divisor + 1;
        }
        return sum;
    }
}
