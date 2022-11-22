public class GuessNumberHigherOrLower {
    private int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
