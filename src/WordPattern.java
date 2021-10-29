import java.util.HashSet;
import java.util.Objects;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            int currentIndex = pattern.charAt(i) - 'a';

            if (map[currentIndex] == null) {
                map[currentIndex] = words[i];
            } else if (!Objects.equals(map[currentIndex], words[i])) {
                return false;
            }
        }

        int count = 0;
        HashSet<String> nonRepeatWords = new HashSet<>();
        for (String word : map) {
            if (word != null) {
                nonRepeatWords.add(word);
                count++;
            }
        }

        return count == nonRepeatWords.size();
    }
}
