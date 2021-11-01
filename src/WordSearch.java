public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && isFound(board, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isFound(char[][] board, String wordRemain, int i, int j) {
        if (wordRemain.length() == 0) {
            return true;
        }

        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] != wordRemain.charAt(0)) {
                return false;
            }
            String newWordRemain = wordRemain.substring(1);
            char temp = board[i][j];
            board[i][j] = '#';
            boolean exist = isFound(board, newWordRemain, i + 1, j) || isFound(board, newWordRemain, i - 1, j) ||
                    isFound(board, newWordRemain, i, j + 1) || isFound(board, newWordRemain, i, j - 1);
            board[i][j] = temp;
            return exist;
        }

        return false;
    }
}
