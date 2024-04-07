import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    HashSet<Pair<Integer, Integer>> currIsland = new HashSet<>();
                    dfs(grid, visited, currIsland, i, j, m, n, i, j);
                    islands.add(currIsland);
                }
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, HashSet<Pair<Integer, Integer>> currIsland,
                     int baseI, int baseJ, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        currIsland.add(new Pair<>(i - baseI, j - baseJ));
        dfs(grid, visited, currIsland, baseI, baseJ, m, n, i - 1, j);
        dfs(grid, visited, currIsland, baseI, baseJ, m, n, i + 1, j);
        dfs(grid, visited, currIsland, baseI, baseJ, m, n, i, j - 1);
        dfs(grid, visited, currIsland, baseI, baseJ, m, n, i, j + 1);
    }
}
