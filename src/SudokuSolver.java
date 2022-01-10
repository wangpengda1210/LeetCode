import java.util.HashSet;

public class SudokuSolver {
    boolean solved = false;

    public void solveSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int value = Integer.parseInt(board[row][col] + "");
                    rows[row].add(value);
                    cols[col].add(value);
                    boxes[getBoxIndex(row, col)].add(value);
                }
            }
        }

        addNumber(0, 0, board, rows, cols, boxes);
    }

    private void addNumber(int row, int col, char[][] board, HashSet<Integer>[] rows, HashSet<Integer>[] cols, HashSet<Integer>[] boxes) {
        if (row > 8 || col > 8) {
            solved = true;
            return;
        }

        int box = getBoxIndex(row, col);

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (rows[row].contains(i) || cols[col].contains(i) || boxes[box].contains(i)) {
                    continue;
                }

                rows[row].add(i);
                cols[col].add(i);
                boxes[box].add(i);
                board[row][col] = (i + "").charAt(0);

                if (col == 8) {
                    addNumber(row + 1, 0, board, rows, cols, boxes);
                } else {
                    addNumber(row, col + 1, board, rows, cols, boxes);
                }

                if (!solved) {
                    rows[row].remove(i);
                    cols[col].remove(i);
                    boxes[box].remove(i);
                    board[row][col] = '.';
                }
            }
        } else {
            if (col == 8) {
                addNumber(row + 1, 0, board, rows, cols, boxes);
            } else {
                addNumber(row, col + 1, board, rows, cols, boxes);
            }
        }
    }

    private int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
