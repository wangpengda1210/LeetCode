import java.util.Arrays;

public class HandshakesThatDontCross {
    int mod = 1000000007;

    public int numberOfWays(int numPeople) {
        long[] ways = new long[numPeople / 2 + 1];
        Arrays.fill(ways, -1);
        ways[0] = 1;

        dp(ways, numPeople / 2);
        return (int) ways[numPeople / 2];
    }

    private long dp(long[] ways, int numPeople) {
        if (ways[numPeople] != -1) {
            return ways[numPeople];
        }

        ways[numPeople] = 0;
        for (int i = 0; i < numPeople; i++) {
            ways[numPeople] += dp(ways, i) * dp(ways, numPeople - i - 1) % mod;
            ways[numPeople] %= mod;
        }

        return ways[numPeople];
    }
}
