public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] rotate = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotate[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(rotate, 0, nums, 0, nums.length);
    }
}
