import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int longestLength = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (count.containsKey(endChar)) {
                count.put(endChar, count.get(endChar) + 1);
            } else {
                count.put(endChar, 1);
            }

            while (count.containsKey(endChar) && count.get(endChar) > 1) {
                count.put(s.charAt(start), count.get(s.charAt(start)) - 1);
                start++;
            }

            longestLength = Math.max(longestLength, end - start + 1);
            end++;
        }

        return longestLength;
    }
}
