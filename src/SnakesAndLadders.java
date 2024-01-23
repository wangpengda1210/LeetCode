import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class SnakesAndLadders {
    static class Pair<T, S> {
        private T t;
        private S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getKey() {
            return t;
        }

        public S getValue() {
            return s;
        }

        public void setT(T t) {
            this.t = t;
        }

        public void setS(S s) {
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> nodes = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();

        nodes.offer(1);
        seen.add(1);
        int levelCount = 1;
        int steps = 0;

        while (!nodes.isEmpty()) {
            int next = nodes.poll();
            levelCount--;

            Pair<Integer, Integer> nextIndex = labelToIndex(next, n);
            if (board[nextIndex.getKey()][nextIndex.getValue()] != -1) {
                next = board[nextIndex.getKey()][nextIndex.getValue()];
            }

            if (next == n * n) return steps;

            for (int i = next + 1; i <= Math.min(next + 6, n * n); i++) {
                if (!seen.contains(i)) {
                    nodes.offer(i);
                    seen.add(i);
                }
            }

            if (levelCount == 0) {
                levelCount = nodes.size();
                steps++;
            }
        }

        return -1;
    }

    private Pair<Integer, Integer> labelToIndex(int i, int n) {
        int rowFromBottom = (i - 1) / n;
        int row = n - rowFromBottom - 1;
        if (rowFromBottom % 2 == 0) {
            return new Pair<>(row, (i - 1) % n);
        } else {
            return new Pair<>(row, n - (i - 1) % n - 1);
        }
    }
}
