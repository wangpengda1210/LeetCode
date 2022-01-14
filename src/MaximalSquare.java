public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m + 1][n + 1];
        int maxSqu = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    result[i][j] = Math.min(result[i - 1][j], Math.min(result[i][j - 1], result[i - 1][j - 1])) + 1;
                    maxSqu = Math.max(maxSqu, result[i][j]);
                }
            }
        }

        return maxSqu * maxSqu;
    }
}
