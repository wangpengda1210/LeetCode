import java.util.ArrayList;
import java.util.HashMap;

public class IntersectTwoArray2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums1) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (count.containsKey(num) && count.get(num) > 0) {
                result.add(num);
                count.put(num, count.get(num) - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
