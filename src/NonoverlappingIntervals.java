import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int removeNumber = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                removeNumber++;
            } else {
                end = intervals[i][1];
            }
        }

        return removeNumber;
    }
}
