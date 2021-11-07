public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);

        return (word1.length() - lcs) + (word2.length() - lcs);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[2][text2.length() + 1];
        dp[0][0] = dp[1][0] = 0;

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        int layer = 0;
        for (int i = 0; i < text1.length(); i++) {
            layer++;
            int current = layer % 2;
            int another = (layer - 1) % 2;
            int c = c1[i];
            for (int j = 0; j < text2.length(); j++) {
                if (c == c2[j]) {
                    dp[current][j + 1] = dp[another][j] + 1;
                } else {
                    dp[current][j + 1] = Math.max(dp[current][j], dp[another][j + 1]);
                }
            }
        }

        return dp[layer % 2][text2.length()];
    }
}
