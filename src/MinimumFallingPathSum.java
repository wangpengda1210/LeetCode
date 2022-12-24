import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prevRow = matrix[0];

        for (int i = 1; i < n; i++) {
            int[] currRow = new int[n];

            for (int j = 0; j < n; j++) {
                int minSum = prevRow[j] + matrix[i][j];
                if (j != 0) {
                    minSum = Math.min(minSum, prevRow[j - 1] + matrix[i][j]);
                }
                if (j != n - 1) {
                    minSum = Math.min(minSum, prevRow[j + 1] + matrix[i][j]);
                }
                currRow[j] = minSum;
            }
            prevRow = currRow;
        }

        int min = Integer.MAX_VALUE;
        for (int sum : prevRow) {
            if (sum < min) {
                min = sum;
            }
        }

        return min;
    }
}
