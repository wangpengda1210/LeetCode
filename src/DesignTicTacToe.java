public class DesignTicTacToe {
    class TicTacToe {

        int n;
        int[] rows;
        int[] cols;
        int dia;
        int antiDia;

        public TicTacToe(int n) {
            this.n = n;
            this.rows = new int[n];
            this.cols = new int[n];
            this.dia = 0;
            this.antiDia = 0;
        }

        public int move(int row, int col, int player) {
            int score = player == 1 ? 1 : -1;
            this.rows[row] += score;
            this.cols[col] += score;

            if (row == col) {
                this.dia += score;
            }

            if (row + col == this.n - 1) {
                this.antiDia += score;
            }

            if (Math.abs(this.rows[row]) == n || Math.abs(this.cols[col]) == n ||
                    Math.abs(this.dia) == n || Math.abs(this.antiDia) == n) {
                return player;
            }

            return 0;
        }
    }
}
