public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];

        int prefixLength = 0;
        outer:while (prefixLength < base.length()) {
            char c = base.charAt(prefixLength);
            for (int j = 1; j < strs.length; j++) {
                if (prefixLength == strs[j].length() || strs[j].charAt(prefixLength) != c) {
                    break outer;
                }
            }
            prefixLength++;
        }

        return base.substring(0, prefixLength);
    }
}
