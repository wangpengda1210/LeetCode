public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int zeros = 0;
        while (n >= 5) {
            zeros += n / 5;
            n /= 5;
        }
        return zeros;
    }
}
