public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        if (s.isEmpty() || p.isEmpty()) {
            return false;
        }

        int sl = s.length();
        int pl = p.length();

        boolean[][] result = new boolean[sl + 1][pl + 1];
        result[0][0] = true;

        for (int j = 2; j <= pl; j += 2) {
            if (p.charAt(j - 1) == '*' && result[0][j - 2]) {
                result[0][j] = true;
            }
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '.') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (pChar == '*') {
                    char toMatch = p.charAt(j - 2);
                    if (toMatch != '.' && toMatch != sChar) {
                        result[i][j] = result[i][j - 2];
                    } else {
                        result[i][j] = result[i][j - 2] || result[i - 1][j - 2] || result[i - 1][j];
                    }
                } else {
                    result[i][j] = result[i - 1][j - 1] && sChar == pChar;
                }
            }
        }

        return result[sl][pl];
    }
}
