public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int i = xor & (-xor);

        int x = 0;
        for (int num : nums) {
            if ((num & i) == 0) {
                x ^= num;
            }
        }

        return new int[] { x, x ^ xor };
    }
}
