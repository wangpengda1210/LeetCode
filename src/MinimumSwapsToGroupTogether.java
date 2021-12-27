public class MinimumSwapsToGroupTogether {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i : data) {
            ones += i;
        }

        int currOnes = 0;
        for (int i = 0; i < ones; i++) {
            currOnes += data[i];
        }
        int minSwap = ones - currOnes;

        for (int i = ones; i < data.length; i++) {
            currOnes += data[i] - data[i - ones];
            minSwap = Math.min(minSwap, ones - currOnes);
        }

        return minSwap;
    }
}
