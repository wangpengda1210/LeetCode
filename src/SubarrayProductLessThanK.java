public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int answer = 0;
        int product = 1;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (product >= k) {
                product /= nums[j];
                j++;
            }

            answer += i - j + 1;
        }

        return answer;
    }
}
