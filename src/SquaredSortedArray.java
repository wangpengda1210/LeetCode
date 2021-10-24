public class SquaredSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] sortedArray = new int[nums.length];

        int firstPositive = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                firstPositive = i;
                break;
            }
        }

        int neg = firstPositive - 1;
        int pos = firstPositive;
        int arrayPos = 0;

        while (neg >= 0 && pos < nums.length) {
            int negNum = nums[neg];
            int posNum = nums[pos];

            if (negNum * negNum <= posNum * posNum) {
                sortedArray[arrayPos] = negNum * negNum;
                neg--;
            } else {
                sortedArray[arrayPos] = posNum * posNum;
                pos++;
            }

            arrayPos++;
        }

        while (neg >= 0) {
            sortedArray[arrayPos] = nums[neg] * nums[neg];
            arrayPos++;
            neg--;
        }

        while (pos < nums.length) {
            sortedArray[arrayPos] = nums[pos] * nums[pos];
            arrayPos++;
            pos++;
        }

        return sortedArray;
    }
}
