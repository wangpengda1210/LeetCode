import java.util.LinkedList;
import java.util.Queue;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 * More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 * <p>
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that
 * every edge in the graph connects a node in set A and a node in set B.
 * <p>
 * Return true if and only if it is bipartite.
 */

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (group[i] == 0) {
                Queue<Integer> nodes = new LinkedList<>();
                nodes.add(i);
                group[i] = 1;

                while (!nodes.isEmpty()) {
                    int next = nodes.poll();
                    for (int neighbor : graph[next]) {
                        if (group[neighbor] == group[next]) {
                            return false;
                        }
                        if (group[neighbor] != 0) {
                            continue;
                        }
                        nodes.add(neighbor);
                        group[neighbor] = 2 - group[next] + 1;
                    }
                }
            }
        }

        return true;
    }
}
