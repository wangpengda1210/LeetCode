public class JumpGame {
    public boolean canJump(int[] nums) {
        int canJumpTo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > canJumpTo) {
                return false;
            }

            if (nums[i] + i > canJumpTo) {
                canJumpTo = nums[i] + i;
            }

            if (canJumpTo >= nums.length) {
                return true;
            }
        }

        return true;
    }
}
