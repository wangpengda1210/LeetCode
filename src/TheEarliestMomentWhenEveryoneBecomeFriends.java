import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int components = n;

        Arrays.sort(logs, Comparator.comparingInt(e -> e[0]));
        for (int[] log : logs) {
            int p1 = getParent(parents, log[1]);
            int p2 = getParent(parents, log[2]);

            if (p1 != p2) {
                parents[p1] = p2;
                components--;
            }

            if (components <= 0) {
                return log[0];
            }
        }

        return -1;
    }

    private int getParent(int[] parents, int curr) {
        while (curr != parents[curr]) {
            parents[curr] = parents[parents[curr]];
            curr = parents[curr];
        }

        return curr;
    }
}
