import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> nodes = new ArrayList<>();
        int[] incoming = new int[n];

        for (List<Integer> edge : edges) {
            incoming[edge.get(1)]++;
        }

        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                nodes.add(i);
            }
        }

        return nodes;
    }
}
