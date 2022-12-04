import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        PriorityQueue<int[]> schedule = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int count : taskCount) {
            int currTime = 0;
            for (int i = count; i > 0; i--) {
                schedule.add(new int[] { currTime, i });
                currTime += n + 1;
            }
        }

        int time = 0;
        while (!schedule.isEmpty()) {
            if (time >= schedule.peek()[0]) {
                schedule.poll();
            }
            time++;
        }

        return time;
    }
}
