import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> uniqueCount = new HashSet<>();

        for (int num : count.keySet()) {
            if (uniqueCount.contains(count.get(num))) {
                return false;
            }
            uniqueCount.add(count.get(num));
        }

        return true;
    }
}
