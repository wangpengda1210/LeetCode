import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    class RecentCounter {
        Queue<Integer> calls;
        int count;

        public RecentCounter() {
            calls = new LinkedList<>();
            count = 0;
        }

        public int ping(int t) {
            int leftRange = t - 3000;
            while (!calls.isEmpty() && calls.peek() < leftRange) {
                calls.poll();
                count--;
            }
            calls.add(t);
            count++;
            return count;
        }
    }
}
