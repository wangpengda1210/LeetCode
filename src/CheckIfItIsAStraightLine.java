public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int dy = coordinates[1][1] - coordinates[0][1];
        int dx = coordinates[1][0] - coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++) {
            if (dy * (coordinates[i][0] - coordinates[0][0]) != dx * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }
        }

        return true;
    }
}
