import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (k == 0 && val > 1) {
                result++;
            } else if (k > 0 && map.containsKey(key + k)){
                result++;
            }
        }

        return result;
    }
}
