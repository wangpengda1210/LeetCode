import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();

        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int start = i;
            HashMap<String, Integer> currWordCount = new HashMap<>();
            int correctWords = 0;

            for (int end = start; end <= s.length() - wordLength; end += wordLength) {
                String next = s.substring(end, end + wordLength);
                if (!wordCount.containsKey(next)) {
                    currWordCount.clear();
                    correctWords = 0;
                    start = end + wordLength;
                } else {
                    while (Objects.equals(currWordCount.getOrDefault(next, 0), wordCount.get(next))) {
                        String toRemove = s.substring(start, start + wordLength);
                        currWordCount.put(toRemove, currWordCount.get(toRemove) - 1);
                        correctWords--;
                        start += wordLength;
                    }

                    if (end - start >= wordLength * words.length) {
                        String toRemove = s.substring(start, start + wordLength);
                        currWordCount.put(toRemove, currWordCount.get(toRemove) - 1);
                        correctWords--;
                        start += wordLength;
                    }

                    currWordCount.put(next, currWordCount.getOrDefault(next, 0) + 1);
                    correctWords++;

                    if (correctWords == words.length) {
                        result.add(start);
                    }
                }
            }
        }

        return result;
    }
}
