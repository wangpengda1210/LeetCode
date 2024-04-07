import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        return toDes(graph, seen, visited, source, destination);
    }

    private boolean toDes(List<Integer>[] graph, HashSet<Integer> seen, HashSet<Integer> visited, int source, int destination) {
        if (visited.contains(source)) {
            return true;
        }

        if (seen.contains(source)) {
            return false;
        }

        if (graph[source].isEmpty()) {
            return source == destination;
        }

        seen.add(source);
        for (int child : graph[source]) {
            if (!toDes(graph, seen, visited, child, destination)) {
                return false;
            }
        }
        visited.add(source);

        return true;
    }
}
