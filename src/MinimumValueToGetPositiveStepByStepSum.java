public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }

        return min > 0 ? 1 : -min + 1;
    }
}
