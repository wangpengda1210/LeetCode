import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sorted = String.valueOf(letters);

            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }

            groups.get(sorted).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
