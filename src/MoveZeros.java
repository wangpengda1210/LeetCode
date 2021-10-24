public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int currPos = 0;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currPos] = nums[i];
                currPos++;
            } else {
                zeroCount++;
            }
        }

        for (int j = 1; j <= zeroCount; j++) {
            nums[nums.length - j] = 0;
        }
    }
}
