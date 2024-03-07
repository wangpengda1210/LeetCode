import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        PriorityQueue<int[]> workers = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int start = 0;
        while (start < candidates) {
            workers.add(new int[] { costs[start], 0 });
            start++;
        }

        int end = costs.length - 1;
        for (int i = 0; i < candidates; i++) {
            if (end < start) {
                break;
            }
            workers.add(new int[] { costs[end], 1 });
            end--;
        }

        for (int i = 0; i < k; i++) {
            int[] next = workers.poll();
            cost += next[0];
            if (end >= start) {
                if (next[1] == 0) {
                    workers.add(new int[] { costs[start], 0 });
                    start++;
                } else {
                    workers.add(new int[] { costs[end], 1 });
                    end--;
                }
            }
        }

        return cost;
    }
}
