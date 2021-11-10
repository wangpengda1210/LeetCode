public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n];

        for (int[] aTrust : trust) {
            trusted[aTrust[0] - 1]--;
            trusted[aTrust[1] - 1]++;
        }

        for (int i = 0; i < trusted.length; i++) {
            if (trusted[i] == n - 1) return i + 1;
        }

        return -1;
    }
}
