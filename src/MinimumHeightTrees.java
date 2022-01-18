import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n < 2) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }

            return result;
        }

        HashMap<Integer, List<Integer>> neighbors = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            List<Integer> xNei = neighbors.getOrDefault(x, new ArrayList<>());
            xNei.add(y);
            List<Integer> yNei = neighbors.getOrDefault(y, new ArrayList<>());
            yNei.add(x);

            neighbors.put(x, xNei);
            neighbors.put(y, yNei);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int nei = neighbors.get(leaf).get(0);
                List<Integer> neiNei = neighbors.get(nei);
                neiNei.remove((Integer) leaf);

                if (neiNei.size() == 1) {
                    newLeaves.add(nei);
                }

                neighbors.put(nei, neiNei);
                neighbors.remove(leaf);
            }

            remainingNodes -= leaves.size();
            leaves = newLeaves;
        }

        result.addAll(neighbors.keySet());
        return result;
    }
}
