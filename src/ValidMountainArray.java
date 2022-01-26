public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        if (arr[0] >= arr[1]) {
            return false;
        }

        boolean isIncrease = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (isIncrease) {
                if (arr[i] == arr[i + 1]) {
                    return false;
                }

                if (arr[i] > arr[i + 1]) {
                    isIncrease = false;
                }
            } else if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return !isIncrease;
    }
}
