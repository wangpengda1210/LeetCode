import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(0, 0);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);

        return find(n, map, n);
    }

    private List<String> find(int n, HashMap<Integer, Integer> map, int curr) {
        if (curr == 0) {
            return List.of("");
        }

        if (curr == 1) {
            return List.of("0", "1", "8");
        }

        List<String> minusTwo = find(n, map, curr - 2);
        List<String> result = new ArrayList<>();

        for (String str : minusTwo) {
            for (int num : map.keySet()) {
                if (curr == n && num == 0) {
                    continue;
                }
                result.add(num + str + map.get(num));
            }
        }

        return result;
    }
}
