public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int digit = n % 10;
            next += digit * digit;
            n = n / 10;
        }

        return next;
    }
}
