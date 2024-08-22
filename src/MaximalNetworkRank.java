import java.util.HashMap;
import java.util.HashSet;

/**
 * There is an infrastructure of n cities with some number of roads connecting these cities.
 * Each roads[i] = [a_i, b_i] indicates that there is a bidirectional road between cities a_i and b_i.
 * <p>
 * The network rank of two different cities is defined as the total number of directly connected roads to either city.
 * If a road is directly connected to both cities, it is only counted once.
 * <p>
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * <p>
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();
        int[] degrees = new int[n];

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            degrees[from]++;
            degrees[to]++;
            neighbors.computeIfAbsent(from, e -> new HashSet<>()).add(to);
            neighbors.computeIfAbsent(to, e -> new HashSet<>()).add(from);
        }

        int maxRank = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (degrees[i] + degrees[j] > maxRank) {
                    maxRank = degrees[i] + degrees[j];
                    if (neighbors.containsKey(i) && neighbors.get(i).contains(j)) {
                        maxRank--;
                    }
                }
            }
        }

        return maxRank;
    }
}
