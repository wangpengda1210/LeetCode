import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> nodes = new LinkedList<>();

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost = 0;

        int[][] length = new int[m][n];
        for (int[] r : length) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        dfs(length, grid, m, n, 0, 0, cost);

        int size = 0;
        while (!nodes.isEmpty()) {
            if (size == 0) {
                cost++;
                size = nodes.size();
            }

            int[] node = nodes.poll();
            for (int[] dir : directions) {
                dfs(length, grid, m, n, node[0] + dir[0], node[1] + dir[1], cost);
            }
            size--;
        }

        return length[m - 1][n - 1];
    }

    private void dfs(int[][] length, int[][] grid, int m, int n, int r, int c, int cost) {
        if (r < 0 || r >= m || c < 0 || c >= n || length[r][c] != Integer.MAX_VALUE) {
            return;
        }

        length[r][c] = cost;
        nodes.offer(new int[] {r, c});
        int next = grid[r][c] - 1;
        dfs(length, grid, m, n, r + directions[next][0], c + directions[next][1], cost);
    }
}
