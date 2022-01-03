import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> nodes = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    nodes.add(new int[] { i, j });
                }
            }
        }

        while (!nodes.isEmpty()) {
            int[] node = nodes.poll();
            int i = node[0];
            int j = node[1];
            int currentDistance = rooms[i][j] + 1;

            if (i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
                rooms[i - 1][j] = currentDistance;
                nodes.offer(new int[] { i - 1, j });
            }

            if (i + 1 < m && rooms[i + 1][j] == Integer.MAX_VALUE) {
                rooms[i + 1][j] = currentDistance;
                nodes.offer(new int[] { i + 1, j });
            }

            if (j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
                rooms[i][j - 1] = currentDistance;
                nodes.offer(new int[] { i, j - 1 });
            }

            if (j + 1 < n && rooms[i][j + 1] == Integer.MAX_VALUE) {
                rooms[i][j + 1] = currentDistance;
                nodes.offer(new int[] { i, j + 1 });
            }
        }
    }
}
