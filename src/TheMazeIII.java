import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMazeIII {
    static class State {
        int x;
        int y;
        int dist;
        String path;

        public State(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[ball[0]][ball[1]] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) {
                return o1.path.compareTo(o2.path);
            }

            return o1.dist - o2.dist;
        });
        pq.add(new State(ball[0], ball[1], 0, ""));

        int[][] dirs = new int[][] {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        char[] dirIns = new char[] { 'd', 'u', 'r', 'l' };

        while (!pq.isEmpty()) {
            State next = pq.poll();
            if (next.x == hole[0] && next.y == hole[1]) {
                return next.path;
            }
            if (distance[next.x][next.y] < next.dist) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];

                int newX = next.x;
                int newY = next.y;
                int newDis = next.dist;

                while (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                    newDis++;
                    if (newX == hole[0] && newY == hole[1]) {
                        newX += dir[0];
                        newY += dir[1];
                        newDis++;
                        break;
                    }
                }

                newX -= dir[0];
                newY -= dir[1];
                newDis--;

                if (newX == next.x && newY == next.y) {
                    continue;
                }

                if (newDis <= distance[newX][newY]) {
                    distance[newX][newY] = newDis;
                    pq.add(new State(newX, newY, newDis, next.path + dirIns[i]));
                }
            }
        }

        return "impossible";
    }
}
