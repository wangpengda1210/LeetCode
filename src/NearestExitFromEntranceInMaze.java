import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> cells = new ArrayDeque<>();

        distance[entrance[0]][entrance[1]] = 0;
        cells.add(entrance);

        while (!cells.isEmpty()) {
            int[] cell = cells.poll();
            int neighbourDistance = distance[cell[0]][cell[1]] + 1;

            for (int[] neighbour : directions) {
                int row = cell[0] + neighbour[0];
                int col = cell[1] + neighbour[1];

                if (row < 0 || row >= m || col < 0 || col >= n ||
                        maze[row][col] != '.') {
                    continue;
                }

                cells.add(new int[] {row, col});
                distance[row][col] = neighbourDistance;
                maze[row][col] = '-';

                if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
                    return neighbourDistance;
                }
            }
        }

        return -1;
    }
}
