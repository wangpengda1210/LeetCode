public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return score(nums, 0, nums.length - 1, true) >= 0;
    }

    private int score(int[] nums, int start, int end, boolean isTurn) {
        int sign = isTurn ? 1 : -1;

        if (start >= end) {
            return sign * nums[start];
        }

        int chooseStart = sign * nums[start] + score(nums, start + 1, end, !isTurn);
        int chooseEnd = sign * nums[end] + score(nums, start, end - 1, !isTurn);

        return sign * Math.max(sign * chooseStart, sign * chooseEnd);
    }
}
