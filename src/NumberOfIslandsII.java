import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfIslandsII {
    private class Pair<T, U> {
        T t;
        U u;

        public Pair(T t, U u) {
            this.t = t;
            this.u = u;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair<?,?>)) {
                return false;
            }
            Pair p = (Pair) obj;

            return p.u.equals(this.u) && p.t.equals(this.t);
        }

        @Override
        public int hashCode() {
            return t.hashCode() + u.hashCode();
        }
    }

    int[][] dirs = new int[][] {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parents = new int[positions.length];
        HashMap<Pair<Integer, Integer>, Integer> indices = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            int[] position = positions[i];

            parents[i] = i;
            Pair<Integer, Integer> newPair = new Pair<>(position[0], position[1]);
            if (!indices.containsKey(newPair)) {
                indices.put(newPair, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < positions.length; i++) {
            if (i == indices.get(new Pair<>(positions[i][0], positions[i][1]))) {
                int numIslands = result.get(i - 1);

                List<Integer> nei = new ArrayList<>();
                HashSet<Integer> neiParents = new HashSet<>();
                for (int[] dir : dirs) {
                    int newM = positions[i][0] + dir[0];
                    int newN = positions[i][1] + dir[1];

                    if (newM < 0 || newM >= m || newN < 0 || newN >= n) {
                        continue;
                    }

                    Pair<Integer, Integer> neiPair = new Pair<>(newM, newN);
                    if (indices.containsKey(neiPair) && indices.get(neiPair) < i) {
                        int neiIndex = indices.get(neiPair);
                        nei.add(neiIndex);
                        neiParents.add(findParent(parents, neiIndex));
                    }
                }

                for (Integer integer : nei) {
                    union(parents, i, integer);
                }
                numIslands -= neiParents.size() - 1;

                result.add(numIslands);
            } else {
                result.add(result.get(i - 1));
            }
        }

        return result;
    }

    private void union(int[] parents, int i, int j) {
        int iParent = findParent(parents, i);
        int jParent = findParent(parents, j);

        if (iParent != jParent) {
            parents[jParent] = iParent;
        }
    }

    private int findParent(int[] parents, int curr) {
        while (curr != parents[curr]) {
            parents[curr] = parents[parents[curr]];
            curr = parents[curr];
        }

        return curr;
    }
}
