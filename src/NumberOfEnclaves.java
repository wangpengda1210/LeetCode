/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * <p>
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * <p>
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, m, n);
                    if (size != -1) {
                        num += size;
                    }
                }
            }
        }

        return num;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return -1;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int first = dfs(grid, i - 1, j, m, n);
        int second = dfs(grid, i + 1, j, m, n);
        int third = dfs(grid, i, j - 1, m, n);
        int fourth = dfs(grid, i, j + 1, m, n);

        if (first == -1 || second == -1 || third == -1 || fourth == -1) {
            return -1;
        }

        return first + second + third + fourth + 1;
    }
}
