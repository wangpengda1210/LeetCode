import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int end = points[0][1];
        int arrows = points.length;

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] <= end) {
                arrows--;
            } else {
                end = point[1];
            }
        }

        return arrows;
    }
}
