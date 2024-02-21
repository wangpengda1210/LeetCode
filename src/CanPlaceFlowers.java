public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        int flowerPlaced = 0;

        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (prev == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                flowerPlaced++;
                if (flowerPlaced == n) {
                    return true;
                }
            }
            prev = flowerbed[i];
        }

        if (prev == 0 && flowerbed[flowerbed.length - 1] == 0) {
            flowerPlaced++;
        }
        return flowerPlaced >= n;
    }
}
