public class FindPeakElementII {
    private int getElement(int i, int j, int[][] mat) {
        try {
            return mat[i][j];
        } catch (Exception e) {
            return -1;
        }
    }

    public int[] findPeakGrid(int[][] mat) {
        int width = mat[0].length;
        int height = mat.length;

        int left = 0;
        int right = width - 1;

        while (true) {
            int mid = left + (right - left) / 2;

            for (int i = 0; i < height; i++) {
                if (mat[i][mid] > getElement(i + 1, mid, mat) && mat[i][mid] > getElement(i - 1, mid, mat)) {
                    if (mat[i][mid] > getElement(i, mid - 1, mat) && mat[i][mid] > getElement(i, mid + 1, mat)) {
                        return new int[] {i, mid};
                    } else if (mat[i][mid] > getElement(i, mid - 1, mat)) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                    break;
                }
            }
        }
    }
}
