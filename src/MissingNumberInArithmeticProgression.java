public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int correctValue = arr[0] + diff * mid;

            if (arr[mid] != correctValue) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return arr[0] + diff * left;
    }
}
