/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Return the kth positive integer that is missing from this array.
 */

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= mid + 1 + k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start + k;
    }
}
