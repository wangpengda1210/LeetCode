public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int[] differences = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            differences[i - 1] = nums[i] - nums[i - 1];
        }

        int slices = 0;
        int count = 1;
        int difference = differences[0];

        for (int i = 1; i < differences.length; i++) {
            if (differences[i] == difference) {
                count++;
            } else {
                if (count >= 2) {
                    slices += (count - 1) * count / 2;
                }
                count = 1;
                difference = differences[i];
            }
        }

        if (count >= 2) {
            slices += (count - 1) * count / 2;
        }

        return slices;
    }
}
