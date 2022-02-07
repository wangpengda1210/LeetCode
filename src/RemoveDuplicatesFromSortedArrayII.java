public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 1;
        int j = 1;

        int currNum = nums[0];
        int currCount = 1;

        int numCount = 1;

        while (j < nums.length) {
            nums[i] = nums[j];

            if (nums[j] == currNum) {
                currCount++;
            } else {
                currNum = nums[j];
                currCount = 1;
            }

            if (currCount <= 2) {
                i++;
                numCount++;
            }
            j++;
        }

        return numCount;
    }
}
