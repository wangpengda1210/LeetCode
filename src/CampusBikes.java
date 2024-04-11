import java.util.Arrays;
import java.util.PriorityQueue;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < workers.length; i++) {
            int workerX = workers[i][0];
            int workerY = workers[i][1];
            for (int j = 0; j < bikes.length; j++) {
                pq.add(new int[] { Math.abs(workerX - bikes[j][0]) + Math.abs(workerY - bikes[j][1]), i, j });
            }
        }

        int[] ans = new int[workers.length];
        Arrays.fill(ans, -1);

        boolean[] bikeAssigned = new boolean[bikes.length];
        int workerCount = 0;
        while (!pq.isEmpty() && workerCount < workers.length) {
            int[] next = pq.poll();
            if (ans[next[1]] == -1 && !bikeAssigned[next[2]]) {
                ans[next[1]] = next[2];
                bikeAssigned[next[2]] = true;
                workerCount++;
            }
        }

        return ans;
    }
}
