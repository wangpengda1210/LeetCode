import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DesignSnakeGame {
    class Pair<T, S> {
        T t;
        S s;

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

    class SnakeGame {
        int width;
        int height;
        int[][] food;
        int score;
        int foodPos;
        int x;
        int y;
        HashSet<Pair<Integer, Integer>> snakes;
        Queue<Pair<Integer, Integer>> positions;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.score = 0;
            this.foodPos = 0;
            this.x = 0;
            this.y = 0;
            this.snakes = new HashSet<>();
            this.positions = new LinkedList<>();
            snakes.add(new Pair<>(0, 0));
            positions.add(new Pair<>(0, 0));
        }

        public int move(String direction) {
            switch (direction.charAt(0)) {
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    x++;
                    break;
            }

            if (x < 0 || x >= width || y < 0 || y >= height) {
                return -1;
            }

            if (foodPos < food.length && food[foodPos][0] == y && food[foodPos][1] == x) {
                score++;
                foodPos++;
            } else {
                Pair<Integer, Integer> first = positions.poll();
                snakes.remove(first);
            }

            Pair<Integer, Integer> next = new Pair<>(x, y);

            if (snakes.contains(next)) {
                return -1;
            }

            snakes.add(next);
            positions.add(next);

            return score;
        }
    }
}
