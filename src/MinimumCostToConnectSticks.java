import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick : sticks) {
            pq.add(stick);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int next = pq.poll() + pq.poll();
            cost += next;
            pq.add(next);
        }

        return cost;
    }
}
