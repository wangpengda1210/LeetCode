import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> neighbours = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            ArrayList<Integer> fromNei = neighbours.getOrDefault(from, new ArrayList<>());
            fromNei.add(to);
            neighbours.put(from, fromNei);

            ArrayList<Integer> toNei = neighbours.getOrDefault(to, new ArrayList<>());
            toNei.add(from);
            neighbours.put(to, toNei);
        }

        int[] distances = new int[n];
        boolean[] seen = new boolean[n];
        int[] deeperCount = new int[n];

        dfs(0, neighbours, distances, seen, deeperCount);

        boolean[] newSeen = new boolean[n];
        getResult(0, neighbours, distances, newSeen, deeperCount, n);

        return distances;
    }

    private void dfs(int node, HashMap<Integer, ArrayList<Integer>> neighbours, int[] distances,
                     boolean[] seen, int[] deeperCount) {
        seen[node] = true;

        for (int nei : neighbours.getOrDefault(node, new ArrayList<>())) {
            if (!seen[nei]) {
                dfs(nei, neighbours, distances, seen, deeperCount);
                deeperCount[node] += deeperCount[nei] + 1;
                distances[node] += distances[nei] + deeperCount[nei] + 1;
            }
        }
    }

    private void getResult(int node, HashMap<Integer, ArrayList<Integer>> neighbours, int[] distances,
                           boolean[] seen, int[] deeperCount, int n) {
        seen[node] = true;

        for (int nei : neighbours.getOrDefault(node, new ArrayList<>())) {
            if (!seen[nei]) {
                distances[nei] += distances[node] - distances[nei] - deeperCount[nei] - 1 + n - deeperCount[nei] - 1;
                getResult(nei, neighbours, distances, seen, deeperCount, n);
            }
        }
    }
}
