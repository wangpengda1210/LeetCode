public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 0;
        int right = (int) Math.ceil(x / 2.0);
        while (left < right) {
            int mid = left + (right - left) / 2;
            long mul = (long) mid * mid;
            if (mul > x) {
                right = mid;
            } else if (mul < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left - 1;
    }
}
