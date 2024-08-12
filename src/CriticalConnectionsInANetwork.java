import java.util.*;

public class CriticalConnectionsInANetwork {
    class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getKey() {
            return t;
        }

        public S getValue() {
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashSet<Pair<Integer, Integer>> conn = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] nodeOrder = new int[n];
        Arrays.fill(nodeOrder, -1);

        for (List<Integer> edge : connections) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
            conn.add(new Pair<>(Math.min(from, to), Math.max(from, to)));
        }

        dfs(conn, graph, nodeOrder, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (Pair<Integer, Integer> criticalEdge : conn) {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).add(criticalEdge.getKey());
            result.get(result.size() - 1).add(criticalEdge.getValue());
        }

        return result;
    }

    private int dfs(HashSet<Pair<Integer, Integer>> conn, HashMap<Integer, List<Integer>> graph, int[] nodeOrder,
                    int curr, int order) {
        if (nodeOrder[curr] != -1) {
            return nodeOrder[curr];
        }

        nodeOrder[curr] = order;
        int minOrder = order;

        for (int nei : graph.get(curr)) {
            int neiOrder = nodeOrder[nei];
            if (neiOrder != -1 && neiOrder == order - 1) {
                continue;
            }

            int neiOrderEnd = dfs(conn, graph, nodeOrder, nei, order + 1);
            if (neiOrderEnd <= order) {
                conn.remove(new Pair<>(Math.min(curr, nei), Math.max(curr, nei)));
            }

            minOrder = Math.min(minOrder, neiOrderEnd);
        }

        return minOrder;
    }
}
