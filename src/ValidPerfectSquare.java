/**
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * <p>
 * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 * <p>
 * You must not use any built-in library function, such as sqrt.
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long start = 2;
        long end = num / 2;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            }

            if (mid * mid > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
