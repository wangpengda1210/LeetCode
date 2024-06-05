/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
 * <p>
 * The north direction is the positive direction of the y-axis.
 * The south direction is the negative direction of the y-axis.
 * The east direction is the positive direction of the x-axis.
 * The west direction is the negative direction of the x-axis.
 * The robot can receive one of three instructions:
 * <p>
 * "G": go straight 1 unit.
 * "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
 * "R": turn 90 degrees to the right (i.e., clockwise direction).
 * The robot performs the instructions given in order, and repeats them forever.
 * <p>
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 0;
        int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || dir != 0;
    }
}
