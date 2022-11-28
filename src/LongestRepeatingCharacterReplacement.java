public class LongestRepeatingCharacterReplacement {
    private int getCharIndex(char c) {
        return c - 'A';
    }

    private int maxFreq(int[] letterCount) {
        int max = 0;
        for (int count : letterCount) {
            max = Math.max(max, count);
        }

        return max;
    }

    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {
            return k;
        }

        int p1 = 0;
        int p2 = 0;

        int[] letterCount = new int[26];
        int maxSize = 0;

        while (p2 < s.length()) {
            letterCount[getCharIndex(s.charAt(p2))]++;
            int windowSize = p2 - p1 + 1;

            while (windowSize - maxFreq(letterCount) > k) {
                letterCount[getCharIndex(s.charAt(p1))]--;
                p1++;
                windowSize--;
            }

            maxSize = Math.max(windowSize, maxSize);
            p2++;
        }

        return maxSize;
    }
}
