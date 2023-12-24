public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[] neighbors = { -1, 0, 1 };
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                for (int neiI : neighbors) {
                    for (int neiJ : neighbors) {
                        if (!(neiI == 0 && neiJ == 0)) {
                            int newI = i + neiI;
                            int newJ = j + neiJ;

                            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols &&
                                    (board[newI][newJ] == 1 || board[newI][newJ] == -1)) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (liveNeighbors != 2 && liveNeighbors != 3) {
                        board[i][j] = -1;
                    }
                } else if (liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}
