import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];

        addQueen(board, result, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    private void addQueen(int[][] board, List<List<String>> result, int row, HashSet<Integer> cols, HashSet<Integer> dia, HashSet<Integer> antiDia) {
        int n = board.length;
        if (row == board.length) {
            ArrayList<String> res = new ArrayList<>();
            for (int[] ints : board) {
                StringBuilder sb = new StringBuilder();
                for (int i : ints) {
                    sb.append(i == 0 ? '.' : 'Q');
                }
                res.add(sb.toString());
            }
            result.add(res);
            return;
        }

        for (int col = 0; col < n; col++) {
            int currDia = row - col;
            int currAntiDia = row + col;

            if (!cols.contains(col) && !dia.contains(currDia) && !antiDia.contains(currAntiDia)) {
                cols.add(col);
                dia.add(currDia);
                antiDia.add(currAntiDia);

                board[row][col] = 1;
                addQueen(board, result, row + 1, cols, dia, antiDia);

                cols.remove(col);
                dia.remove(currDia);
                antiDia.remove(currAntiDia);
                board[row][col] = 0;
            }
        }
    }
}
