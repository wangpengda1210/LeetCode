import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!row.contains(board[i][j])) {
                        row.add(board[i][j]);
                    } else {
                        return false;
                    }
                }

                if (board[j][i] != '.') {
                    if (!col.contains(board[j][i])) {
                        col.add(board[j][i]);
                    } else {
                        return false;
                    }
                }

                int baseRow = (i / 3) * 3;
                int baseCol = (i % 3) * 3;
                char element = board[baseRow + (j / 3)][baseCol + (j % 3)];
                if (element != '.') {
                    if (!box.contains(element)) {
                        box.add(element);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
