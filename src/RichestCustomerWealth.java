import java.util.Arrays;

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
 * Return the wealth that the richest customer has.
 * <p>
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] person : accounts) {
            max = Math.max(max, Arrays.stream(person).sum());
        }
        return max;
    }
}
