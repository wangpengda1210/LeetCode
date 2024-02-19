import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int[] first = points[i];
            HashMap<Double, Integer> slopes = new HashMap<>();
            int vertical = 1;
            for (int j = i + 1; j < points.length; j++) {
                int[] second = points[j];
                if (first[0] == second[0]) {
                    vertical++;
                } else {
                    double slope = ((double) second[1] - first[1]) / (second[0] - first[0]);
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                    slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                    max = Math.max(max, slopes.get(slope) + 1);
                }
                max = Math.max(max, vertical);
            }
        }

        return max;
    }
}
