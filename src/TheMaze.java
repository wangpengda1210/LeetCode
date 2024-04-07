import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> cells = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();

        cells.add(start);
        seen.add(cooToIndex(start, n));

        int[][] dirs = new int[][] {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};

        while (!cells.isEmpty()) {
            int[] next = cells.poll();

            if (next[0] == destination[0] && next[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int newX = next[0];
                int newY = next[1];

                while (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                }

                newX -= dir[0];
                newY -= dir[1];

                int[] newPos = new int[] { newX, newY };
                if (!seen.contains(cooToIndex(newPos, n))) {
                    seen.add(cooToIndex(newPos, n));
                    cells.add(newPos);
                }
            }
        }

        return false;
    }

    private int cooToIndex(int[] pos, int n) {
        return pos[0] * n + pos[1];
    }
}
