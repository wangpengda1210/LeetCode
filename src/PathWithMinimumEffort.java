import java.util.LinkedList;
import java.util.Queue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 * and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int start = 0;
        int end = 1000000;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (bfs(heights, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    private boolean bfs(int[][] heights, int maxDiff) {
        Queue<int[]> nodes = new LinkedList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;
        nodes.add(new int[] { 0, 0 });

        while (!nodes.isEmpty()) {
            int[] next = nodes.poll();
            if (next[0] == heights.length - 1 && next[1] == heights[0].length - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int newI = next[0] + dir[0];
                int newJ = next[1] + dir[1];
                if (newI >= 0 && newI < heights.length && newJ >= 0 && newJ < heights[0].length
                        && !visited[newI][newJ] && Math.abs(heights[newI][newJ] - heights[next[0]][next[1]]) <= maxDiff) {
                    visited[newI][newJ] = true;
                    nodes.add(new int[] { newI, newJ });
                }
            }
        }

        return false;
    }
}
