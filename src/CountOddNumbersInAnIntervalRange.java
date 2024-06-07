/**
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        return (high - low) / 2 + ((low % 2 == 1 || high % 2 == 1) ? 1 : 0);
    }
}
