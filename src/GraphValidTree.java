import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        HashMap<Integer, List<Integer>> neighbours = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            List<Integer> xNei = neighbours.getOrDefault(x, new ArrayList<>());
            List<Integer> yNei = neighbours.getOrDefault(y, new ArrayList<>());

            xNei.add(y);
            yNei.add(x);

            neighbours.put(x, xNei);
            neighbours.put(y, yNei);
        }

        dfs(0, neighbours, seen);

        return seen.size() == n;
    }

    private void dfs(int curr, HashMap<Integer, List<Integer>> neighbours, HashSet<Integer> seen) {
        if (!seen.contains(curr)) {
            seen.add(curr);
            if (neighbours.containsKey(curr)) {
                for (int nei : neighbours.get(curr)) {
                    dfs(nei, neighbours, seen);
                }
            }
        }
    }
}
