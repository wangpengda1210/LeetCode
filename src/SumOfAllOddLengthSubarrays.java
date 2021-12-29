public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sums = new int[arr.length + 1];

        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < sums.length; j = j + 2) {
                sum += sums[j] - sums[i];
            }
        }

        return sum;
    }
}
