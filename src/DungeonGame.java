import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;

                int curr = dungeon[i][j];
                int minHealth = Integer.MAX_VALUE;

                if (i != m - 1) {
                    int down = dp[i + 1][j];
                    minHealth = Math.min(minHealth, down - curr);
                }

                if (j != n - 1) {
                    int right = dp[i][j + 1];
                    minHealth = Math.min(minHealth, right - curr);
                }

                if (minHealth <= 0) {
                    minHealth = 1;
                }

                dp[i][j] = minHealth;
            }
        }

        return dp[0][0];
    }
}
