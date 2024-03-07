import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> cells = new LinkedList<>();

        cells.add(entrance);
        maze[entrance[0]][entrance[1]] = '!';

        int distance = 0;
        int cellsRemain = 1;

        while (!cells.isEmpty()) {
            int[] next = cells.poll();
            cellsRemain--;

            int row = next[0];
            int col = next[1];

            for (int[] dir : directions) {
                int neiRow = row + dir[0];
                int neiCol = col + dir[1];

                if (neiRow < 0 || neiRow >= m || neiCol < 0 || neiCol >= n) {
                    continue;
                }

                if (maze[neiRow][neiCol] == '.') {
                    if (neiRow == 0 || neiRow == m - 1 || neiCol == 0 || neiCol == n - 1) {
                        return distance + 1;
                    }

                    cells.add(new int[] { neiRow, neiCol });
                    maze[neiRow][neiCol] = '!';
                }
            }

            if (cellsRemain == 0) {
                distance++;
                cellsRemain = cells.size();
            }
        }

        return -1;
    }
}
