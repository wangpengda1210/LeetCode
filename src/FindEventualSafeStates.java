import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 * meaning there is an edge from node i to each node in graph[i].
 * <p>
 * A node is a terminal node if there are no outgoing edges.
 * A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
 * <p>
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashSet<Integer> safe = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                safe.add(i);
                seen.add(i);
                visited.add(i);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            dfs(graph, i, safe, seen, visited);
        }

        List<Integer> result = new java.util.ArrayList<>(safe.stream().toList());
        Collections.sort(result);
        return result;
    }

    private void dfs(int[][] graph, int id, HashSet<Integer> safe, HashSet<Integer> seen, HashSet<Integer> visited) {
        seen.add(id);
        boolean isSafe = true;
        for (int next : graph[id]) {
            if (!seen.contains(next)) {
                dfs(graph, next, safe, seen, visited);
                if (!safe.contains(next)) {
                    isSafe = false;
                }
            } else if (!visited.contains(next)) {
                isSafe = false;
            } else if (!safe.contains(next)) {
                isSafe = false;
            }
        }
        visited.add(id);
        if (isSafe) {
            safe.add(id);
        }
    }
}
