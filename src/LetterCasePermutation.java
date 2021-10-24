import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();

        findPermutation(permutations, s.toCharArray(), 0);

        return permutations;
    }

    private void findPermutation(List<String> permutations, char[] s, int currentPosition) {
        if (currentPosition == s.length) {
            permutations.add(new String(s));
            return;
        }

        char currentChar = s[currentPosition];
        if (Character.isUpperCase(currentChar)) {
            s[currentPosition] = Character.toLowerCase(currentChar);
            findPermutation(permutations, s, currentPosition + 1);
            s[currentPosition] = currentChar;
        } else if (Character.isLowerCase(currentChar)) {
            s[currentPosition] = Character.toUpperCase(currentChar);
            findPermutation(permutations, s, currentPosition + 1);
            s[currentPosition] = currentChar;
        }

        findPermutation(permutations, s, currentPosition + 1);
    }
}
