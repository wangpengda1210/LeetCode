public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        int[] rowCount = new int[picture.length];
        int[] colCount = new int[picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
