import java.util.ArrayList;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> times = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            times.add(new int[] { startTime[i], endTime[i], profit[i] });
        }

        times.sort(Comparator.comparingInt(i -> i[0]));

        int[] maxProfit = new int[startTime.length];
        maxProfit[startTime.length - 1] = times.get(startTime.length - 1)[2];

        for (int i = startTime.length - 2; i >= 0; i--) {
            int nextIndex = findNext(i + 1, times.get(i)[1], times);
            if (nextIndex == times.size()) {
                maxProfit[i] = Math.max(times.get(i)[2], maxProfit[i + 1]);
            } else {
                maxProfit[i] = Math.max(times.get(i)[2] + maxProfit[nextIndex], maxProfit[i + 1]);
            }
        }

        return maxProfit[0];
    }

    private int findNext(int startIndex, int time, ArrayList<int[]> times) {
        int start = startIndex;
        int end = times.size();

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (times.get(mid)[0] >= time) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
