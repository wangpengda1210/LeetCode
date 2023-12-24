import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            if (lastSeen.containsKey(next) && i - lastSeen.get(next) <= k) {
                return true;
            }
            lastSeen.put(next, i);
        }

        return false;
    }
}
