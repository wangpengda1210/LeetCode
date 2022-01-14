import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> dis = new HashMap<>();

        for (int[] dislike : dislikes) {
            int x = dislike[0];
            int y = dislike[1];

            List<Integer> xDislike = dis.getOrDefault(x, new ArrayList<>());
            List<Integer> yDislike = dis.getOrDefault(y, new ArrayList<>());

            xDislike.add(y);
            yDislike.add(x);

            dis.put(x, xDislike);
            dis.put(y, yDislike);
        }

        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (!first.contains(i) && !second.contains(i)) {
                if (!dfs(dis, first, second, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> dis, HashSet<Integer> first, HashSet<Integer> second, int curr) {
        boolean canFirst = true;
        boolean canSecond = true;

        for (int nei : dis.get(curr)) {
            if (first.contains(nei)) {
                canFirst = false;
            }
            if (second.contains(curr)) {
                canSecond = false;
            }

            if (!canFirst && !canSecond) {
                return false;
            }
        }

        if (canFirst) {
            first.add(curr);
        } else {
            second.add(curr);
        }

        for (int nei : dis.get(curr)) {
            if (!dfs(dis, first, second, nei)) {
                return false;
            }
        }

        return true;
    }
}
