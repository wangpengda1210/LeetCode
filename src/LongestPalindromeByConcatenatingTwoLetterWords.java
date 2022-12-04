import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> pWords = new HashMap<>();
        int sameCount = 0;
        int length = 0;

        for (String word : words) {
            boolean sameLetters = word.charAt(0) == word.charAt(1);

            if (pWords.containsKey(word) && pWords.get(word) > 0) {
                pWords.put(word, pWords.get(word) - 1);
                length += 4;
                if (sameLetters) {
                    sameCount--;
                }
            } else {
                String pWord = word.substring(1) + word.charAt(0);
                pWords.put(pWord, pWords.getOrDefault(pWord, 0) + 1);
                if (sameLetters) {
                    sameCount++;
                }
            }
        }

        if (sameCount > 0) {
            length += 2;
        }

        return length;
    }
}
