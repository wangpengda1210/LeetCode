import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        HashMap<String, HashSet<String>> mapping = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            if (!mapping.containsKey(word1)) {
                mapping.put(word1, new HashSet<>());
            }

            if (!mapping.containsKey(word2)) {
                mapping.put(word2, new HashSet<>());
            }

            mapping.get(word1).add(word2);
            mapping.get(word2).add(word1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }

            if (!mapping.containsKey(sentence1[i]) || !mapping.get(sentence1[i]).contains(sentence2[i])) {
                return false;
            }
        }

        return true;
    }
}
