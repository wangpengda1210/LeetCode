import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int count = 0;
        int end = 0;

        for (int[] interval : intervals) {
            if (end < interval[1]) {
                count++;
                end = interval[1];
            }
        }

        return count;
    }
}
