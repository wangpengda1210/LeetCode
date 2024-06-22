import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < start + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
