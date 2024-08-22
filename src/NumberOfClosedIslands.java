import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 */

public class NumberOfClosedIslands {
    int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int closedIsland(int[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (bfs(grid, i, j, m, n)) {
                        num++;
                    }
                }
            }
        }

        return num;
    }

    private boolean bfs(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> cells = new LinkedList<>();
        cells.add(new int[] { i, j });
        grid[i][j] = 1;
        boolean isClosed = true;

        while (!cells.isEmpty()) {
            int[] next = cells.poll();
            int x = next[0];
            int y = next[1];

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    isClosed = false;
                    continue;
                }
                if (grid[newX][newY] == 1) {
                    continue;
                }
                grid[newX][newY] = 1;
                cells.add(new int[] { newX, newY });
            }
        }

        return isClosed;
    }
}
