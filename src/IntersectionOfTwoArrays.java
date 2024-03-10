import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> unique1 = new HashMap<>();
        for (int num : nums1) {
            unique1.put(num, true);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (unique1.containsKey(num) && unique1.get(num)) {
                unique1.put(num, false);
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
