import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> letters = new HashMap<>();

        int start = 0;
        int end = 0;

        int longest = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            letters.put(endChar, letters.getOrDefault(endChar, 0) + 1);

            if (letters.keySet().size() <= 2) {
                end++;
            } else {
                longest = Math.max(longest, end - start);
                while (letters.keySet().size() > 2) {
                    char startChar = s.charAt(start);
                    letters.put(startChar, letters.get(startChar) - 1);
                    if (letters.get(startChar) <= 0) {
                        letters.remove(startChar);
                    }
                    start++;
                }
                end++;
            }
        }

        longest = Math.max(longest, end - start);
        return longest;
    }
}
