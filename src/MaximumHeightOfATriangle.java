/**
 * You are given two integers red and blue representing the count of red and blue colored balls.
 * You have to arrange these balls to form a triangle such that the 1st row will have 1 ball, the 2nd row will have 2 balls,
 * the 3rd row will have 3 balls, and so on.
 * <p>
 * All the balls in a particular row should be the same color, and adjacent rows should have different colors.
 * <p>
 * Return the maximum height of the triangle that can be achieved.
 */

public class MaximumHeightOfATriangle {
    public int maxHeightOfTriangle(int red, int blue) {
        int red1 = (int) Math.sqrt(red);
        int blue1 = (int) (Math.sqrt(blue + 0.25) - 0.5);

        int line1 = Math.min(red1, blue1) * 2 + ((red1 > blue1) ? 1 : 0);

        int red2 = (int) (Math.sqrt(red + 0.25) - 0.5);
        int blue2 = (int) Math.sqrt(blue);

        int line2 = Math.min(red2, blue2) * 2 + ((blue2 > red2) ? 1 : 0);

        return Math.max(line1, line2);
    }
}
