import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(queries[i], nums);
        }

        return result;
    }

    private int binarySearch(int target, int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid + 1;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
