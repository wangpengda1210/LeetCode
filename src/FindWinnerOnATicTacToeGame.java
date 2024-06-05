/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * <p>
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
 * return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 */

public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[] cols = new int[3];
        int[] rows = new int[3];
        int dia = 0;
        int antiDia = 0;

        int turn = 1;

        for (int[] move : moves) {
            rows[move[0]] += turn;
            cols[move[1]] += turn;
            if (move[0] == move[1]) {
                dia += turn;
            }
            if (move[0] + move[1] == 2) {
                antiDia += turn;
            }

            if (Math.abs(dia) == 3 || Math.abs(antiDia) == 3
                    || Math.abs(rows[move[0]]) == 3 || Math.abs(cols[move[1]]) == 3) {
                return turn == 1 ? "A" : "B";
            }

            turn *= -1;
        }

        return moves.length >= 9 ? "Draw" : "Pending";
    }
}
