public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int balls = grid[0].length;
        int[] result = new int[balls];

        for (int i = 0; i < balls; i++) {
            int row = 0;
            int col = i;

            while (row < grid.length) {
                if (grid[row][col] == 1) {
                    col++;
                    if (col >= balls || grid[row][col] == -1) {
                        result[i] = -1;
                        break;
                    }
                } else {
                    col--;
                    if (col < 0 || grid[row][col] == 1) {
                        result[i] = -1;
                        break;
                    }
                }

                row++;
            }

            if (row == grid.length) {
                result[i] = col;
            }
        }

        return result;
    }
}
