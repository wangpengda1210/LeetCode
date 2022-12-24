import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> stopBuses = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int stop : route) {
                HashSet<Integer> buses = stopBuses.getOrDefault(stop, new HashSet<>());
                buses.add(i);
                stopBuses.put(stop, buses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> visitedBuses = new HashSet<>();
        Queue<Integer> nextStops = new ArrayDeque<>();
        nextStops.offer(source);

        int currBuses = 0;
        int currLayer = 0;

        while (!nextStops.isEmpty()) {
            if (currLayer == 0) {
                currBuses++;
                currLayer = nextStops.size();
            }

            int nextStop = nextStops.poll();
            if (nextStop == target) {
                return currBuses - 1;
            }

            visited.add(nextStop);

            for (Integer integer : stopBuses.get(nextStop)) {
                if (!visitedBuses.contains(integer)) {
                    visitedBuses.add(integer);
                    int[] routeStops = routes[integer];
                    for (int routeStop : routeStops) {
                        if (!visited.contains(routeStop)) {
                            nextStops.offer(routeStop);
                        }
                    }
                }
            }

            currLayer--;
        }

        return -1;
    }
}
