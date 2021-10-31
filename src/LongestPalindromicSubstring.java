public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        int longest = 0;
        String longestString = "";

        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else {
                    boolean sameChar = s.charAt(i) == s.charAt(j);
                    if (j == i + 1) {
                        isPalindrome[i][j] = sameChar;
                    } else {
                        isPalindrome[i][j] = sameChar && isPalindrome[i + 1][j - 1];
                    }
                }

                int length = j - i + 1;
                if (length > longest && isPalindrome[i][j]) {
                    longest = length;
                    longestString = s.substring(i, j + 1);
                }
            }
        }

        return longestString;
    }
}
