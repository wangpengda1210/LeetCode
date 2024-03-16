public class WiggleSort {
    public void wiggleSort(int[] nums) {
        boolean even = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (even && nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }

            if (!even && nums[i] < nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }

            even = !even;
        }
    }
}
