public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            return 1.0 / (x * myPow(x, -(n + 1)));
        }

        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        if (n % 2 == 1) {
            return x * myPow(x * x, n / 2);
        }

        return myPow(x * x, n / 2);
    }
}
