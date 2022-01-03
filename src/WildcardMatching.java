public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;

        boolean[][] match = new boolean[m][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') {
                    match[j][i] = match[j - 1][i - 1];
                } else if (p.charAt(i - 1) == '*') {
                    for (int backJ = j; backJ >= 1; backJ--) {
                        if (match[backJ][i]) {
                            match[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return match[m - 1][n - 1];
    }
}
