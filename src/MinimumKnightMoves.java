import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[601][601];
        int[][] moves = new int[][] {{ -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 },
                { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }};

        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(new int[] { 0, 0 });
        visited[300][300] = true;

        int steps = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                int[] next = nodes.poll();

                assert next != null;
                if (next[0] == x && next[1] == y) {
                    return steps;
                }

                for (int[] move : moves) {
                    int newX = next[0] + move[0];
                    int newY = next[1] + move[1];

                    if (newX < -300 || newX > 300 || newY < -300 || newY > 300) {
                        continue;
                    }

                    if (!visited[newX + 300][newY + 300]) {
                        visited[newX + 300][newY + 300] = true;
                        nodes.add(new int[] { newX, newY });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
