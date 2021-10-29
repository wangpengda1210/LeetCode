public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                BFS(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                BFS(board, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                BFS(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                BFS(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void BFS(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O') {
            board[row][col] = 'Y';
            BFS(board, row - 1, col);
            BFS(board, row + 1, col);
            BFS(board, row, col - 1);
            BFS(board, row, col + 1);
        }
    }
}
