public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        int amount = 0;

        for (int[] shi : shift) {
            if (shi[0] == 0) {
                amount += shi[1];
            } else {
                amount -= shi[1];
            }
        }

        amount = amount % s.length();
        if (amount < 0) {
            amount = s.length() - Math.abs(amount);
        }

        return s.substring(amount) + s.substring(0, amount);
    }
}
