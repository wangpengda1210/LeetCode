import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        int rottenThisRound;
        int rottenNextRound = 0;
        int minute = 0;

        Queue<int[]> rottenQueue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 2) {
                    rottenNextRound++;
                    rottenQueue.offer(new int[]{i, j});
                } else if (ints[j] == 1) {
                    freshOrange++;
                }
            }
        }

        while (!rottenQueue.isEmpty() && freshOrange > 0) {
            rottenThisRound = rottenNextRound;
            rottenNextRound = 0;
            while (rottenThisRound > 0) {
                int[] rottenOrange = rottenQueue.poll();
                assert rottenOrange != null;
                int row = rottenOrange[0];
                int col = rottenOrange[1];

                int[][] checks = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
                for (int[] check : checks) {
                    int r = check[0];
                    int c = check[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            rottenQueue.offer(new int[] {r, c});
                            rottenNextRound++;
                            freshOrange--;
                        }
                    }
                }
                rottenThisRound--;
            }
            minute++;
        }

        if (freshOrange > 0) {
            return -1;
        }

        return minute;
    }
}
