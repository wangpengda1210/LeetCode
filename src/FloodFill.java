public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int currentColor = image[sr][sc];
        image[sr][sc] = newColor;

        if (sr != 0 && image[sr - 1][sc] == currentColor) {
            floodFill(image, sr - 1, sc, newColor);
        }

        if (sr != image.length - 1 && image[sr + 1][sc] == currentColor) {
            floodFill(image, sr + 1, sc, newColor);
        }

        if (sc != 0 && image[sr][sc - 1] == currentColor) {
            floodFill(image, sr, sc - 1, newColor);
        }

        if (sc != image[0].length - 1 && image[sr][sc + 1] == currentColor) {
            floodFill(image, sr, sc + 1, newColor);
        }

        return image;
    }
}
