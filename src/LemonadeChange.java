/**
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time
 * (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 * <p>
 * Note that you do not have any change in hand at first.
 * <p>
 * Given an integer array bills where bills[i] is the bill the ith customer pays,
 * return true if you can provide every customer with the correct change, or false otherwise.
 */

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for (int bill : bills) {
            if (bill == 10) {
                if (fiveCount == 0) {
                    return false;
                } else {
                    fiveCount--;
                }
                tenCount++;
            } else if (bill == 5) {
                fiveCount++;
            } else {
                if (fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
