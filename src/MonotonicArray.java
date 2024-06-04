public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int state = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                if (state == 0) {
                    state = 1;
                } else if (state == -1) {
                    return false;
                }
            } else if (nums[i + 1] < nums[i]) {
                if (state == 0) {
                    state = -1;
                } else if (state == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
