import java.util.HashMap;
import java.util.Objects;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> count1 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> count2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            count2.put(c, count2.getOrDefault(c, 0) + 1);
        }

        HashMap<Integer, Integer> swapCount = new HashMap<>();
        for (char c : count1.keySet()) {
            if (!count2.containsKey(c)) {
                return false;
            }
            int firstCount = count1.get(c);
            int secondCount = count2.get(c);

            if (firstCount != secondCount) {
                swapCount.put(firstCount, swapCount.getOrDefault(firstCount, 0) + 1);
                swapCount.put(secondCount, swapCount.getOrDefault(secondCount, 0) - 1);
            }
        }

        for (int i : swapCount.keySet()) {
            if (swapCount.get(i) != 0) {
                return false;
            }
        }

        return true;
    }
}
