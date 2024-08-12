import java.util.*;

/**
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
 * Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * <p>
 * You are given two arrays redEdges and blueEdges where:
 * <p>
 * redEdges[i] = [a_i, b_i] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * blueEdges[j] = [u_j, v_j] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * Return an array answer of length n,
 * where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path,
 * or -1 if such a path does not exist.
 */

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();
        boolean[][] visited = new boolean[2][n];
        int[] result = new int[n];

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            red.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            blue.get(edge[0]).add(edge[1]);
        }

        Queue<int[]> nodes = new LinkedList<>();
        // 0 for blue, 1 for red
        visited[0][0] = true;
        visited[1][0] = true;
        // Queue of array [i, j] where i is the color of edge to this node and j is the node id
        nodes.add(new int[] { 0, 0 });
        nodes.add(new int[] { 1, 0 });
        int distance = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                int[] next = nodes.poll();
                int color = next[0];
                int node = next[1];
                if (result[node] == -1) {
                    result[node] = distance;
                }

                if (color == 0) {
                    for (int nei : red.get(node)) {
                        if (!visited[1][nei]) {
                            visited[1][nei] = true;
                            nodes.add(new int[] { 1, nei });
                        }
                    }
                } else {
                    for (int nei : blue.get(node)) {
                        if (!visited[0][nei]) {
                            visited[0][nei] = true;
                            nodes.add(new int[] { 0, nei });
                        }
                    }
                }
            }
            distance++;
        }

        return result;
    }
}
