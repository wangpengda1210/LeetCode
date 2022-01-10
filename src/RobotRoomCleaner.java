import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    static class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
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
    }

    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        visit(robot, 0, 0, 0);
    }

    private void visit(Robot robot, int row, int col, int dir) {
        visited.add(new Pair<>(row, col));

        robot.clean();

        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4;
            int[] nextDir = dirs[newDir];
            int newRow = row + nextDir[0];
            int newCol = col + nextDir[1];

            if (!visited.contains(new Pair<>(newRow, newCol))) {
                if (robot.move()) {
                    visit(robot, newRow, newCol, newDir);

                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
            }

            robot.turnRight();
        }
    }
}
