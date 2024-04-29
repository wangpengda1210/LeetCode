public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        int length = String.valueOf(n).length();

        int curr = n;
        int sum = 0;
        while (curr > 0) {
            sum += (int) Math.pow(curr % 10, length);
            curr /= 10;
        }

        return sum == n;
    }
}
