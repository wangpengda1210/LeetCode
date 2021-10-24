public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int minIndex = searchMinimum(nums, 0, nums.length - 1)[0];
        return searchNumber(nums, target, minIndex, 0, nums.length - 1);
    }

    private int[] searchMinimum(int[] nums, int start, int end) {
        if (end == start) {
            return new int[] {end, nums[end]};
        }

        int mid = start + (end - start) / 2;
        int[] minLeft = searchMinimum(nums, start, mid);
        int[] minRight = searchMinimum(nums, mid + 1, end);

        if (minLeft[1] <= minRight[1]) {
            return minLeft;
        } else {
            return minRight;
        }
    }

    private int searchNumber(int[] nums, int target, int pivot, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        int realMid = (mid + pivot) % nums.length;

        if (target == nums[realMid]) {
            return realMid;
        }
        if (target > nums[realMid]) {
            return searchNumber(nums, target, pivot, mid + 1, end);
        }
        return searchNumber(nums, target, pivot, start, mid - 1);
    }
}
