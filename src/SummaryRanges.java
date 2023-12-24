import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if (start == nums[i]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
        }

        return result;
    }
}
