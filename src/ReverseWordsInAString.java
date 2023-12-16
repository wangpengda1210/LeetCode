import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
