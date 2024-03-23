public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean crushed = true;
        while (crushed) {
            crushed = false;

            // Find crush
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int type = Math.abs(board[i][j]);
                    if (i != 0 && i != m - 1) {
                        if (Math.abs(board[i - 1][j]) == type && Math.abs(board[i + 1][j]) == type) {
                            board[i - 1][j] = -type;
                            board[i][j] = -type;
                            board[i + 1][j] = -type;
                        }
                    }

                    if (j != 0 && j != n - 1) {
                        if (Math.abs(board[i][j - 1]) == type && Math.abs(board[i][j + 1]) == type) {
                            board[i][j - 1] = -type;
                            board[i][j] = -type;
                            board[i][j + 1] = -type;
                        }
                    }
                }
            }

            // Crush
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] < 0) {
                        board[i][j] = 0;
                        crushed = true;
                    }
                }
            }

            // Drop
            for (int j = 0; j < n; j++) {
                int p1 = m - 1;
                int p2 = m - 1;
                int candyCount = 0;

                while (p1 >= 0) {
                    if (board[p1][j] > 0) {
                        board[p2][j] = board[p1][j];
                        p2--;
                        candyCount++;
                    }
                    p1--;
                }

                for (int i = m - 1 - candyCount; i >= 0; i--) {
                    board[i][j] = 0;
                }
            }
        }

        return board;
    }
}
