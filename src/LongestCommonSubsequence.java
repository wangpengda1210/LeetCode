public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] common = new int[text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            int prev = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int max = Math.max(common[j], common[j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    max = Math.max(max, prev + 1);
                }
                prev = common[j];
                common[j] = max;
            }
        }

        return common[text2.length()];
    }
}
