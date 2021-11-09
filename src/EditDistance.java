public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;

        int[][] distances = new int[m][n];

        distances[0][0] = 0;
        for (int i = 1; i < m; i++) {
            distances[i][0] = i;
        }

        for (int j = 1; j < n; j++) {
            distances[0][j] = j;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int change = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                distances[i][j] = Math.min(distances[i - 1][j] + 1, Math.min(distances[i][j - 1] + 1, distances[i - 1][j - 1] + change));
            }
        }

        return distances[m - 1][n - 1];
    }
}
