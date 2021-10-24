import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        sort(intervals, 0, intervals.length - 1);
        List<int[]> newList = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i] = new int[] {intervals[i - 1][0], Math.max(intervals[i][1], intervals[i - 1][1])};
            } else {
                newList.add(intervals[i - 1]);
            }
        }

        newList.add(intervals[intervals.length - 1]);

        int[][] result = new int[newList.size()][2];
        for (int i = 0; i < newList.size(); i++) {
            result[i] = newList.get(i);
        }

        return result;
    }

    private void sort(int[][] intervals, int start, int end) {
        if (start > end) return;
        int pivotIndex = partition(intervals, start, end);
        sort(intervals, start, pivotIndex - 1);
        sort(intervals, pivotIndex + 1, end);
    }

    private int partition(int[][] intervals, int start, int end) {
        int pivot = intervals[end][0];
        int i = start;
        int j = end;

        while (i < j) {
            while (intervals[i][0] < pivot && i < j) {
                i++;
            }
            while (intervals[j][0] >= pivot && i < j) {
                j--;
            }

            int[] temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
        }

        int[] temp = intervals[i];
        intervals[i] = intervals[end];
        intervals[end] = temp;

        return i;
    }
}
