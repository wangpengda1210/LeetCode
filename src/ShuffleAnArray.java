import java.util.Random;

public class ShuffleAnArray {
    private int[] shuffledArray;
    private int[] array;

    public ShuffleAnArray(int[] nums) {
        array = nums;
        shuffledArray = nums.clone();
    }

    public int[] reset() {
        return array;
    }

    public int[] shuffle() {
        Random random = new Random();

        for (int i = 0; i < shuffledArray.length; i++) {
            int shufflePos = random.nextInt(shuffledArray.length - i) + i;

            int temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[shufflePos];
            shuffledArray[shufflePos] = temp;
        }

        return shuffledArray;
    }
}
