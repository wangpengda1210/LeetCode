public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }

        return start;
    }
}
