public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] numCoins = new int[amount + 1];
        numCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            numCoins[i] = Integer.MAX_VALUE;
        }

        for (int coin : coins) {
            if (coin <= amount) {
                numCoins[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (numCoins[i] != 1) {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin >= 0 && numCoins[i - coin] != Integer.MAX_VALUE && numCoins[i - coin] + 1 < min) {
                        min = numCoins[i - coin] + 1;
                    }
                }

                numCoins[i] = min;
            }
        }

        return numCoins[amount] == Integer.MAX_VALUE ? -1 : numCoins[amount];
    }
}
