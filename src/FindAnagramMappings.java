import java.util.HashMap;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            pos.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = pos.get(nums1[i]);
        }

        return ans;
    }
}
