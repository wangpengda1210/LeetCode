public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        int mod = 1000000007;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        long fPrev = 1;
        long f = 2;
        long p = 1;

        for (int i = 3; i <= n; i++) {
            long fTemp = f;
            f = (fPrev + f + p * 2) % mod;
            p = (p + fPrev) % mod;
            fPrev = fTemp;
        }

        return (int) f;
    }
}
