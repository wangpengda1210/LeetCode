import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        int charCount = count.keySet().size();
        int correctCount = 0;
        HashMap<Character, Integer> sCount = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            sCount.put(endChar, sCount.getOrDefault(endChar, 0) + 1);

            if (count.containsKey(endChar) && sCount.get(endChar).intValue() == count.get(endChar).intValue()) {
                correctCount++;
            }

            while (correctCount == charCount) {
                if (end - start < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                sCount.put(startChar, sCount.get(startChar) - 1);
                if (count.containsKey(startChar) && sCount.get(startChar) < count.get(startChar)) {
                    correctCount--;
                }
                start++;
            }

            end++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
