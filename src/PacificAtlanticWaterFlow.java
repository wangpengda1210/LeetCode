import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int[][] directions = new int[][] {
            { 1, 0 },
            { -1, 0 },
            { 0, 1 },
            { 0, -1 }
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            dfs(i, 0, m, n, pacific, heights);
            atlantic[i][n - 1] = true;
            dfs(i, n - 1, m, n, atlantic, heights);
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            dfs(0, j, m, n, pacific, heights);
            atlantic[m - 1][j] = true;
            dfs(m - 1, j, m, n, atlantic, heights);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int m, int n, boolean[][] water, int[][] heights) {
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) {
                continue;
            }

            if (!water[newI][newJ] && heights[newI][newJ] >= heights[i][j]) {
                water[newI][newJ] = true;
                dfs(newI, newJ, m, n, water, heights);
            }
        }
    }
}
