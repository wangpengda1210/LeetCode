import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int result = 0;

        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                int currentValue = count.get(c);
                if (currentValue % 2 == 1) {
                    result += 2;
                }
                count.put(c, currentValue + 1);
            } else {
                count.put(c, 1);
            }
        }

        return result < s.length() ? result + 1 : result;
    }
}
