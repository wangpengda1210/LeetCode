import java.util.ArrayList;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            neighbours.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            neighbours.get(relation[0]).add(relation[1]);
        }

        boolean[] seen = new boolean[n + 1];
        int[] longest = new int[n + 1];

        int maxLength = 1;
        for (int i = 1; i <= n; i++) {
            int theLength = dfs(i, neighbours, seen, longest);
            if (theLength == -1) {
                return -1;
            }
            maxLength = Math.max(maxLength, theLength);
        }

        return maxLength;
    }

    private int dfs(int curr, ArrayList<ArrayList<Integer>> neighbours, boolean[] seen, int[] longest) {
        if (longest[curr] != 0) {
            return longest[curr];
        }

        if (seen[curr]) {
            return -1;
        }

        seen[curr] = true;
        int maxLength = 1;
        for (int child : neighbours.get(curr)) {
            int childLength = dfs(child, neighbours, seen, longest);

            if (childLength == -1) {
                return -1;
            }

            maxLength = Math.max(maxLength, childLength + 1);
        }
        longest[curr] = maxLength;

        return longest[curr];
    }
}
