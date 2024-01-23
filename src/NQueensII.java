import java.util.HashSet;

public class NQueensII {
    int numSolutions;

    public int totalNQueens(int n) {
        numSolutions = 0;
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> digs = new HashSet<>();
        HashSet<Integer> antiDigs = new HashSet<>();

        getNQueens(cols, digs, antiDigs, 0, n);
        return numSolutions;
    }

    private void getNQueens(HashSet<Integer> cols, HashSet<Integer> digs, HashSet<Integer> antiDigs,
                            int currRow, int n) {
        if (currRow == n) {
            numSolutions++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int dig = currRow - col;
            int antiDig = currRow + col;
            if (!(cols.contains(col) || digs.contains(dig) || antiDigs.contains(antiDig))) {
                cols.add(col);
                digs.add(dig);
                antiDigs.add(antiDig);
                getNQueens(cols, digs, antiDigs, currRow + 1, n);
                cols.remove(col);
                digs.remove(dig);
                antiDigs.remove(antiDig);
            }
        }
    }
}
