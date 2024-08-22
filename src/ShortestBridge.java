import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 * <p>
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 * <p>
 * You may change 0's to 1's to connect the two islands to form one island.
 * <p>
 * Return the smallest number of 0's you must flip to connect the two islands.
 */

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int m = grid.length;
        int n = grid[0].length;

        int startX = -1;
        int startY = -1;
        outer:for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    break outer;
                }
            }
        }

        Queue<int[]> lands = new LinkedList<>();
        Queue<int[]> island = new LinkedList<>();
        grid[startX][startY] = 2;
        lands.add(new int[] { startX, startY });
        island.add(new int[] { startX, startY });

        while (!lands.isEmpty()) {
            int[] land = lands.poll();
            int landX = land[0];
            int landY = land[1];
            for (int[] dir : dirs) {
                int newX = landX + dir[0];
                int newY = landY + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1) {
                    continue;
                }
                grid[newX][newY] = 2;
                lands.add(new int[] { newX, newY });
                island.add(new int[] { newX, newY });
            }
        }

        int distance = 0;
        while (!island.isEmpty()) {
            int size = island.size();
            for (int i = 0; i < size; i++) {
                int[] next = island.poll();
                int landX = next[0];
                int landY = next[1];
                for (int[] dir : dirs) {
                    int newX = landX + dir[0];
                    int newY = landY + dir[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 2) {
                        continue;
                    }
                    if (grid[newX][newY] == 1) {
                        return distance;
                    }
                    grid[newX][newY] = 2;
                    island.add(new int[] { newX, newY });
                }
            }
            distance++;
        }

        return 0;
    }
}
