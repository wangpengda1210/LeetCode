import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[][] indexedTasks = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            indexedTasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(indexedTasks, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }
            return o1[1] - o2[1];
        });

        int time = 0;
        int i = 0;
        int[] result = new int[indexedTasks.length];
        int processedTasks = 0;

        while (i < indexedTasks.length) {
            pq.add(indexedTasks[i]);
            i++;

            while (!pq.isEmpty()) {
                int[] next = pq.poll();
                result[processedTasks] = next[2];
                processedTasks++;

                time = Math.max(next[0], time) + next[1];

                while (i < indexedTasks.length && indexedTasks[i][0] <= time) {
                    pq.add(indexedTasks[i]);
                    i++;
                }
            }
        }

        return result;
    }
}
