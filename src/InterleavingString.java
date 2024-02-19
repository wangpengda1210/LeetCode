public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[] interleave = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    interleave[j] = true;
                } else if (i == 0) {
                    interleave[j] = interleave[j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                } else if (j == 0) {
                    interleave[j] = interleave[j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                } else {
                    interleave[j] = (interleave[j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) ||
                            (interleave[j] && s3.charAt(i + j - 1) == s1.charAt(i - 1));
                }
            }
        }

        return interleave[s2.length()];
    }
}
