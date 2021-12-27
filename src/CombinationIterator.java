import java.util.ArrayList;
import java.util.List;

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class CombinationIterator {
    List<String> combinations;
    int current;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        generateCombination(combinations, characters, combinationLength, new StringBuilder(), 0);

        current = 0;
    }

    private void generateCombination(List<String> combinations, String characters, int combinationLength, StringBuilder current, int start) {
        if (current.length() == combinationLength) {
            combinations.add(current.toString());
            return;
        }

        if (characters.length() - start < combinationLength - current.length()) {
            return;
        }

        for (int i = start; i < characters.length(); i++) {
            current.append(characters.charAt(i));
            generateCombination(combinations, characters, combinationLength, current, i + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public String next() {
        String result = combinations.get(current);
        current++;
        return result;
    }

    public boolean hasNext() {
        return current < combinations.size();
    }
}


