public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int negCount = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negCount++;
            }
        }

        return negCount % 2 == 1 ? -1 : 1;
    }
}
