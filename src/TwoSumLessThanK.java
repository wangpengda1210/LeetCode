import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int largest = -1;

        while (i < j) {
            if (nums[i] > k / 2) break;
            int sum = nums[i] + nums[j];
            if (sum < k) {
                if (sum > largest) {
                    largest = sum;
                }
                i++;
            } else {
                j--;
            }
        }

        return largest;
    }
}
