import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDistance = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currSum = first + nums[start] + nums[end];

                if (currSum == target) {
                    return currSum;
                }

                int currDistance = Math.abs(currSum - target);
                if (currDistance < minDistance) {
                    minDistance = currDistance;
                    sum = currSum;
                }

                if (currSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return sum;
    }
}
