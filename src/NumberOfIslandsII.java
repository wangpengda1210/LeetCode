import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        int[] size = new int[m * n];
        int[][] dirs = new int[][] {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
        List<Integer> ans = new ArrayList<>();

        Arrays.fill(parent, -1);

        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            int numIslands = i == 0 ? 0 : ans.get(i - 1);
            int currIndex = posToIndex(position, n);

            if (parent[currIndex] >= 0) {
                ans.add(numIslands);
                continue;
            }

            numIslands++;
            size[currIndex] = 1;
            parent[currIndex] = currIndex;

            for (int[] dir : dirs) {
                int newX = position[0] + dir[0];
                int newY = position[1] + dir[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                int neighborIndex = posToIndex(new int[] { newX, newY }, n);
                if (parent[neighborIndex] >= 0) {
                    numIslands -= union(currIndex, neighborIndex, parent, size);
                }
            }

            ans.add(numIslands);
        }

        return ans;
    }

    private int posToIndex(int[] pos, int n) {
        return pos[0] * n + pos[1];
    }

    private int union(int i, int j, int[] parent, int[] size) {
        int iParent = find(i, parent);
        int jParent = find(j, parent);

        if (iParent == jParent) {
            return 0;
        }

        if (size[i] > size[j]) {
            parent[jParent] = iParent;
            size[iParent] += size[jParent];
        } else {
            parent[iParent] = jParent;
            size[jParent] += size[iParent];
        }

        return 1;
    }

    private int find(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}
