import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToTargetColor {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] distances = new int[3][colors.length];

        for (int i = 0; i < 3; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        int[] current = { 0, 0, 0 };
        for (int i = 0; i < colors.length; i++) {
            int color = colors[i] - 1;
            for (int j = current[color]; j <= i; j++) {
                distances[color][j] = i - j;
                current[color] = i;
            }
        }

        Arrays.fill(current, colors.length - 1);
        for (int i = colors.length - 1; i >= 0; i--) {
            int color = colors[i] - 1;
            for (int j = current[color]; j >= i; j--) {
                distances[color][j] = Math.min(distances[color][j], j - i);
                current[color] = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int res = distances[query[1] - 1][query[0]];
            result.add(res == Integer.MAX_VALUE ? -1 : res);
        }

        return result;
    }
}
