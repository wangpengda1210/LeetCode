import java.util.Arrays;
import java.util.HashMap;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> count = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            count.put(rowString, count.getOrDefault(rowString, 0) + 1);
        }

        int n = grid.length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String colString = Arrays.toString(col);
            if (count.containsKey(colString)) {
                ans += count.get(colString);
            }
        }

        return ans;
    }
}
