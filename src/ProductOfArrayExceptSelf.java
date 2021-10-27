public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        boolean hasZero = false;
        boolean hasTwoZero = false;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else if (hasZero) {
                hasTwoZero = true;
                break;
            } else {
                hasZero = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (hasTwoZero) {
                nums[i] = 0;
            } else if (hasZero) {
                if (nums[i] == 0) {
                    nums[i] = (int) product;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = (int) (product / nums[i]);
            }
        }

        return nums;
    }
}
