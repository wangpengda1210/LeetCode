import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        List<int[]> newList = new ArrayList<>();

        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currEnd) {
                currEnd = Math.max(currEnd, intervals[i][1]);
            } else {
                newList.add(new int[] {currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
        }

        newList.add(new int[] {currStart, currEnd});

        int[][] result = new int[newList.size()][2];
        for (int i = 0; i < newList.size(); i++) {
            result[i] = newList.get(i);
        }

        return result;
    }
}
