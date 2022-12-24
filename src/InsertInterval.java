import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        int start = newStart;
        int end = newEnd;
        if (i < intervals.length) {
            while (i < intervals.length && newEnd >= intervals[i][0]) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(intervals[i][1], end);
                i++;
            }
        }
        result.add(new int[] {start, end});

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        int[][] arr = new int[result.size()][2];
        return result.toArray(arr);
    }
}
