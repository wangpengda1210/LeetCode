import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (char key : frequency.keySet()) {
            int fre = frequency.get(key);
            if (buckets[fre] == null) buckets[fre] = new ArrayList<>();
            buckets[fre].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Character> bucket = buckets[i];
            if (bucket != null) {
                for (char c : bucket) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
