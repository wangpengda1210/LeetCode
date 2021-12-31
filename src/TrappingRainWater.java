public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int sum = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;

                if (height[left] > leftMax) {
                    leftMax = height[left];
                }

                if (height[left] < leftMax && height[left] < rightMax) {
                    sum += Math.min(leftMax, rightMax) - height[left];
                }
            } else {
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }

                if (height[right] < leftMax && height[right] < rightMax) {
                    sum += Math.min(leftMax, rightMax) - height[right];
                }
            }
        }

        return sum;
    }
}
