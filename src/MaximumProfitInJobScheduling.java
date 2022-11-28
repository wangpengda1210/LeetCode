import java.util.ArrayList;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            ArrayList<Integer> job = new ArrayList<>();
            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);
            jobs.add(job);
        }

        jobs.sort(Comparator.comparingInt(i -> i.get(0)));

        int[] maxProfits = new int[startTime.length];
        maxProfits[startTime.length - 1] = jobs.get(startTime.length - 1).get(2);

        for (int i = startTime.length - 2; i >= 0; i--) {
            int nextJob = findNextJob(jobs, i);

            int currProfit = 0;
            if (nextJob >= startTime.length) {
                currProfit = jobs.get(i).get(2);
            } else {
                currProfit = jobs.get(i).get(2) + maxProfits[nextJob];
            }

            maxProfits[i] = Math.max(maxProfits[i + 1], currProfit);
        }

        return maxProfits[0];
    }

    private int findNextJob(ArrayList<ArrayList<Integer>> jobs, int lastIndex) {
        int lastEndTime = jobs.get(lastIndex).get(1);

        int start = lastIndex + 1;
        int end = jobs.size() - 1;
        int nextJob = jobs.size();

        while (start <= end) {
            int mid = (start + end) / 2;
            if (jobs.get(mid).get(0) >= lastEndTime) {
                nextJob = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nextJob;
    }
}
