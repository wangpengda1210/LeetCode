import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> only1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
            if (!set2.contains(num)) {
                only1.add(num);
            }
        }

        HashSet<Integer> only2 = new HashSet<>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                only2.add(num);
            }
        }

        return Arrays.asList(new ArrayList<>(only1), new ArrayList<>(only2));
    }
}
