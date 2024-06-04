public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] border = new int[s.length()];

        int i = 1;
        int prev = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(prev)) {
                prev++;
                border[i] = prev;
                i++;
            } else {
                if (prev == 0) {
                    border[i] = 0;
                    i++;
                } else {
                    prev = border[prev - 1];
                }
            }
        }

        return border[s.length() - 1] != 0 && s.length() % (s.length() - border[s.length() - 1]) == 0;
    }
}
