public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int[] charCount = new int[26];
        int start = 0;
        int end = 0;
        int count = 0;

        while (end < s.length()) {
            char cToAdd = s.charAt(end);
            charCount[cToAdd - 'a']++;

            while (charCount[cToAdd - 'a'] > 1) {
                charCount[s.charAt(start) - 'a']--;
                start++;
            }

            if (end - start + 1 == k) {
                count++;
                charCount[s.charAt(start) - 'a']--;
                start++;
            }

            end++;
        }

        return count;
    }
}
