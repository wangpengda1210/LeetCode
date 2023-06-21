public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 0;
        int prev = 101;

        while (second < nums.length) {
            if (nums[second] != prev) {
                nums[first] = nums[second];
                prev = nums[second];
                first++;
            }
            second++;
        }

        return first;
    }
}
