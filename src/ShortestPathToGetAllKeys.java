import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {
    class State {
        StringBuilder keysFound;
        int x;
        int y;

        public State(StringBuilder keysFound, int x, int y) {
            this.keysFound = keysFound;
            this.x = x;
            this.y = y;
        }
    }

    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int startX = 0;
        int startY = 0;
        StringBuilder allKeys = new StringBuilder("      ");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curr = grid[i].charAt(j);

                if (curr == '@') {
                    startX = i;
                    startY = j;
                } else if (curr >= 'A' && curr <= 'F') {
                    allKeys.setCharAt(curr - 'A', '1');
                }
            }
        }

        Queue<State> states = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int pathLength = 0;
        int size = 1;
        State startState = new State(new StringBuilder("      "), startX, startY);
        states.offer(startState);
        visited.add(startState.keysFound.toString() + "," + startState.x + "," + startState.y);

        while (!states.isEmpty()) {
            if (size == 0) {
                pathLength++;
                size = states.size();
            }

            State state = states.poll();
            if (state.keysFound.toString().equals(allKeys.toString())) {
                return pathLength;
            }

            for (int[] dir : dirs) {
                int newX = state.x + dir[0];
                int newY = state.y + dir[1];
                StringBuilder keysFound = new StringBuilder(state.keysFound);

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                char next = grid[newX].charAt(newY);
                if (next == '#') {
                    continue;
                }

                if (next >= 'A' && next <= 'F' && keysFound.charAt(next - 'A') != '1') {
                    continue;
                }

                if (next >= 'a' && next <= 'f') {
                    keysFound.setCharAt(next - 'a', '1');
                }

                String newKey = keysFound.toString() + "," + newX + "," + newY;
                if (!visited.contains(newKey)) {
                    visited.add(newKey);
                    states.offer(new State(keysFound, newX, newY));
                }
            }

            size--;
        }

        return -1;
    }
}
