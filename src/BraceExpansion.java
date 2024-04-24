import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {
    public String[] expand(String s) {
        List<List<Character>> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                List<Character> currLetter = new ArrayList<>();
                while (s.charAt(i) != '}') {
                    if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                        currLetter.add(s.charAt(i));
                    }
                    i++;
                }
                Collections.sort(currLetter);
                letters.add(currLetter);
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                letters.add(List.of(s.charAt(i)));
            }
        }

        List<String> result = new ArrayList<>();
        expandString(result, letters, new StringBuilder());

        return result.toArray(new String[0]);
    }

    private void expandString(List<String> result, List<List<Character>> letters, StringBuilder curr) {
        if (curr.length() == letters.size()) {
            result.add(curr.toString());
            return;
        }

        for (char letter : letters.get(curr.length())) {
            curr.append(letter);
            expandString(result, letters, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
