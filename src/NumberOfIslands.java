public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numbers = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numbers++;
                    connectIsland(grid, m, n, i, j);
                }
            }
        }

        return numbers;
    }

    private void connectIsland(char[][] grid, int m, int n, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
            grid[i][j] = '2';
            connectIsland(grid, m, n, i + 1, j);
            connectIsland(grid, m, n, i - 1, j);
            connectIsland(grid, m, n, i, j + 1);
            connectIsland(grid, m, n, i, j - 1);
        }
    }
}
