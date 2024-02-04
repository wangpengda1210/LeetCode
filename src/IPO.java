import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<int[]> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new int[] { profits[i], capital[i] });
        }
        projects.sort(Comparator.comparingInt(i -> i[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int pointer = 0;
        for (int i = 0; i < k; i++) {
            while (pointer < profits.length && projects.get(pointer)[1] <= w) {
                queue.add(projects.get(pointer)[0]);
                pointer++;
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
        }

        return w;
    }
}
