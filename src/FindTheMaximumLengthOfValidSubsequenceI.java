/**
 * You are given an integer array nums.
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * <p>
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
 * Return the length of the longest valid subsequence of nums.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 */

public class FindTheMaximumLengthOfValidSubsequenceI {
    public int maximumLength(int[] nums) {
        int odds = 0;
        int evens = 0;
        int evenOdds = 0;
        int oddEvens = 0;
        boolean firstEven = true;
        boolean firstOdd = true;

        for (int num : nums) {
            if (num % 2 == 1) {
                odds++;
                if (firstOdd) {
                    oddEvens++;
                    if (evens > 0) {
                        evenOdds++;
                    }
                }
                firstEven = true;
                firstOdd = false;
            } else {
                evens++;
                if (firstEven) {
                    evenOdds++;
                    if (odds > 0) {
                        oddEvens++;
                    }
                }
                firstOdd = true;
                firstEven = false;
            }
        }

        return Math.max(odds, Math.max(evens, Math.max(evenOdds, oddEvens)));
    }
}
