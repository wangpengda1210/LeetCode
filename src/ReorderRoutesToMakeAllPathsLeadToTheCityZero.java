import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    class Route {
        int to;
        boolean direction;

        public Route(int to, boolean direction) {
            this.to = to;
            this.direction = direction;
        }
    }

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<Route>> routes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            routes.put(i, new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            routes.get(from).add(new Route(to, true));
            routes.get(to).add(new Route(from, false));
        }

        Queue<Integer> nodes = new LinkedList<>();
        boolean[] visited = new boolean[n];
        nodes.add(0);
        visited[0] = true;

        int ans = 0;

        while (!nodes.isEmpty()) {
            int next = nodes.poll();
            for (Route neiNode : routes.get(next)) {
                int nei = neiNode.to;
                if (!visited[nei]) {
                    visited[nei] = true;
                    nodes.add(nei);
                    if (neiNode.direction) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
