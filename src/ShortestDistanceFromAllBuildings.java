import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] distances = new int[m][n];
        int[][] count = new int[m][n];
        int houseCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseCount++;
                    bfs(m, n, grid, distances, count, i, j);
                }
            }
        }

        int minDistances = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == houseCount) {
                    minDistances = Math.min(minDistances, distances[i][j]);
                }
            }
        }

        return minDistances == Integer.MAX_VALUE ? -1 : minDistances;
    }

    private void bfs(int m, int n, int[][] grid, int[][] distances, int[][] count, int x, int y) {
        Queue<int[]> nodes = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        nodes.add(new int[] { x, y });
        visited[x][y] = true;

        int steps = 1;
        int[][] dirs = new int[][] {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                int[] next = nodes.poll();
                for (int[] dir : dirs) {
                    int newX = next[0] + dir[0];
                    int newY = next[1] + dir[1];

                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || grid[newX][newY] != 0) {
                        continue;
                    }

                    visited[newX][newY] = true;
                    distances[newX][newY] += steps;
                    count[newX][newY]++;
                    nodes.add(new int[] { newX, newY });
                }
            }
            steps++;
        }
    }
}
