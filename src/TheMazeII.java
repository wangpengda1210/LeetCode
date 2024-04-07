import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        pq.add(new int[] { start[0], start[1], 0 });

        int[][] dirs = new int[][] {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[0] == destination[0] && next[1] == destination[1]) {
                return next[2];
            }
            if (distance[next[0]][next[1]] < next[2]) {
                continue;
            }

            for (int[] dir : dirs) {
                int newX = next[0];
                int newY = next[1];
                int newDis = next[2];

                while (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                    newDis++;
                }

                newX -= dir[0];
                newY -= dir[1];
                newDis--;

                if (newDis < distance[newX][newY]) {
                    distance[newX][newY] = newDis;
                    pq.add(new int[] { newX, newY, newDis });
                }
            }
        }

        return -1;
    }
}
