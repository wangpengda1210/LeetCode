import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    HashMap<Character, char[]> numberLetters = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        numberLetters.put('2', new char[] {'a', 'b', 'c'});
        numberLetters.put('3', new char[] {'d', 'e', 'f'});
        numberLetters.put('4', new char[] {'g', 'h', 'i'});
        numberLetters.put('5', new char[] {'j', 'k', 'l'});
        numberLetters.put('6', new char[] {'m', 'n', 'o'});
        numberLetters.put('7', new char[] {'p', 'q', 'r', 's'});
        numberLetters.put('8', new char[] {'t', 'u', 'v'});
        numberLetters.put('9', new char[] {'w', 'x', 'y', 'z'});

        List<String> combinations = new ArrayList<>();
        getCombination(combinations, new StringBuilder(), digits);

        return combinations;
    }

    private void getCombination(List<String> combinations, StringBuilder combination, String remainingDigits) {
        if (remainingDigits.length() == 0) {
            if (!combination.toString().equals("")) {
                combinations.add(combination.toString());
            }
            return;
        }

        char digit = remainingDigits.charAt(0);
        for (char letter : numberLetters.get(digit)) {
            combination.append(letter);
            String newRemain = remainingDigits;
            newRemain = newRemain.substring(1);
            getCombination(combinations, combination, newRemain);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
