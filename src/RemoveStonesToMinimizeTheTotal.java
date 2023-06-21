import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int pile : piles) {
            pq.add(pile);
        }

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                return 0;
            }

            int remain = (int) Math.ceil(pq.poll() / 2.0);
            if (remain > 0) {
                pq.add(remain);
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }
}
