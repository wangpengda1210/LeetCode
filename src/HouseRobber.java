public class HouseRobber {
    public int rob(int[] nums) {
        int secondToThis = 0;
        int firstToThis = nums[0];
        int max = firstToThis;

        for (int i = 1; i < nums.length; i++) {
            int currentMax = Math.max(secondToThis + nums[i], firstToThis);
            secondToThis = firstToThis;
            firstToThis = currentMax;
            if (currentMax > max) {
                max = currentMax;
            }
        }

        return max;
    }
}
