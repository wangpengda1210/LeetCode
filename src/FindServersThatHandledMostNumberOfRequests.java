import java.util.*;

public class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] numRequests = new int[k];
        int max = 0;
        TreeSet<Integer> availableServers = new TreeSet<>();
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int arriveTime = arrival[i];

            while (!busyServers.isEmpty() && busyServers.peek()[1] <= arriveTime) {
                availableServers.add(busyServers.poll()[0]);
            }

            if (availableServers.isEmpty()) {
                continue;
            }

            Integer toServe = availableServers.ceiling(i % k);
            if (toServe == null) {
                toServe = availableServers.first();
            }

            availableServers.remove(toServe);
            busyServers.add(new int[] {toServe, arriveTime + load[i]});
            numRequests[toServe]++;
            max = Math.max(max, numRequests[toServe]);
        }

        List<Integer> maxServes = new ArrayList<>();
        for (int i = 0; i < numRequests.length; i++) {
            if (max == numRequests[i]) {
                maxServes.add(i);
            }
        }

        return maxServes;
    }
}
