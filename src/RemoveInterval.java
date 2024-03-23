import java.util.ArrayList;
import java.util.List;

public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                ans.add(List.of(interval[0], interval[1]));
            } else {
                if (interval[0] < toBeRemoved[0]) {
                    ans.add(List.of(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    ans.add(List.of(toBeRemoved[1], interval[1]));
                }
            }
        }

        return ans;
    }
}
