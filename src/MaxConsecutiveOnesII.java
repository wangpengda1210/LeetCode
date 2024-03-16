public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int max = 0;
        int lastZero = -1;

        while (end < nums.length) {
            if (nums[end] == 0) {
                if (lastZero != -1) {
                    start = lastZero + 1;
                }
                lastZero = end;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
