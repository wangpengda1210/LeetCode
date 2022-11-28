public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first;
            first = second;
            second = temp + first;
        }

        return second;
    }
}
