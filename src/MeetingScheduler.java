import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(slots2, Comparator.comparingInt(o -> o[1]));

        int i = 0;
        int j = 0;

        while (i < slots1.length && j < slots2.length) {
            int[] slotA = slots1[i];
            int[] slotB = slots2[j];

            int start = Math.max(slotA[0], slotB[0]);
            int end = Math.min(slotA[1], slotB[1]);
            if (end - start >= duration) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(start);
                result.add(start + duration);
                return result;
            }

            if (slotA[1] <= slotB[1]) {
                i++;
            } else {
                j++;
            }
        }

        return new ArrayList<>();
    }
}
