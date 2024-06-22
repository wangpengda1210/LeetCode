/**
 * You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
 * <p>
 * Return the index of the peak element.
 * <p>
 * Your task is to solve it in O(log(n)) time complexity.
 */

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
