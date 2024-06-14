/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * <p>
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int[] count = new int[26];

        int missCount = 0;
        int maxCount = 0;
        char missS = ' ';
        char missGoal = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                missCount++;
                if (missCount == 1) {
                    missS = s.charAt(i);
                    missGoal = goal.charAt(i);
                } else if (missCount == 2 && (missS != goal.charAt(i) || missGoal != s.charAt(i))) {
                    return false;
                } else if (missCount > 2) {
                    return false;
                }
            }
            count[s.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, count[s.charAt(i) - 'a']);
        }

        if (missCount == 1) {
            return false;
        }

        return missCount != 0 || maxCount >= 2;
    }
}
