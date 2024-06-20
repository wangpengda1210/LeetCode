import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * You are given an array of intervals, where intervals[i] = [start_i, end_i] and each start_i is unique.
 * <p>
 * The right interval for an interval i is an interval j such that start_j >= end_i and start_j is minimized. Note that i may equal j.
 * <p>
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
 */

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<int[], Integer> pos = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            pos.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int[] ans = new int[intervals.length];

        for (int[] interval : intervals) {
            ans[pos.get(interval)] = binarySearch(pos, intervals, interval[1]);
        }

        return ans;
    }

    private int binarySearch(HashMap<int[], Integer> pos, int[][] intervals, int target) {
        int start = 0;
        int end = intervals.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (intervals[mid][0] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start == intervals.length ? -1 : pos.get(intervals[start]);
    }
}
