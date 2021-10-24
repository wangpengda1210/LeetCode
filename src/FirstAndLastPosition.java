public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int smallest = searchSmallest(nums, target, 0, nums.length - 1);
        if (smallest == nums.length) {
            return new int[] {-1, -1};
        }
        return new int[] {smallest, searchLargest(nums, target, 0, nums.length - 1)};
    }

    private int searchSmallest(int[] nums, int target, int start, int end) {
        if (start > end) {
            return nums.length;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return Math.min(mid, searchSmallest(nums, target, start, mid - 1));
        } else if (nums[mid] > target) {
            return searchSmallest(nums, target, start, mid - 1);
        } else {
            return searchSmallest(nums, target, mid + 1, end);
        }
    }

    private int searchLargest(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return Math.max(mid, searchLargest(nums, target, mid + 1, end));
        } else if (nums[mid] > target) {
            return searchLargest(nums, target, start, mid - 1);
        } else {
            return searchLargest(nums, target, mid + 1, end);
        }
    }
}
