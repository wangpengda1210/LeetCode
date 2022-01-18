public class LongestIncreasingPathInAMatrix {
    int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int longest = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    findLongest(i, j, dp, matrix, m, n);
                }
                longest = Math.max(longest, dp[i][j]);
            }
        }

        return longest;
    }

    private int findLongest(int i, int j, int[][] dp, int[][] matrix, int m, int n) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int length = 0;
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI < 0 || newJ < 0 || newI >= m || newJ >= n) {
                continue;
            }

            if (matrix[newI][newJ] < matrix[i][j]) {
                length = Math.max(length, findLongest(newI, newJ, dp, matrix, m, n));
            }
        }

        dp[i][j] = length + 1;
        return dp[i][j];
    }
}
