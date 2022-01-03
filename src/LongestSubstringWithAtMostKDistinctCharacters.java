import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> letters = new HashMap<>();

        int start = 0;
        int end = 0;

        int longest = 0;

        while (end < s.length()) {
            letters.put(s.charAt(end), end);

            if (letters.keySet().size() > k) {
                longest = Math.max(longest, end - start);

                int delPos = Collections.min(letters.values());
                start = delPos + 1;
                letters.remove(s.charAt(delPos));

            }
            end++;
        }

        longest = Math.max(longest, end - start);
        return longest;
    }
}
