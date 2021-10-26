public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int max = Math.min(height[p1], height[p2]) * (p2 - p1);

        while (p1 < p2) {
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }

            if (p1 < p2) {
                int newVolume = Math.min(height[p1], height[p2]) * (p2 - p1);
                if (newVolume > max) {
                    max = newVolume;
                }
            }
        }

        return max;
    }
}
