public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            if (fast == slow) {
                int slow2 = nums[0];
                while (slow != slow2) {
                    slow = nums[slow];
                    slow2 = nums[slow2];
                }

                return slow;
            }
        }
    }
}
