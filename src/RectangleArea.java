public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int totalArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

        if (bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2) {
            return totalArea;
        }

        int maxY1 = Math.max(ay1, by1);
        int minY1 = Math.min(ay1, by1);
        int maxY2 = Math.max(ay2, by2);
        int minY2 = Math.min(ay2, by2);

        int totalY = maxY2 - minY1;
        int overlapY = totalY - (maxY2 - minY2) - (maxY1 - minY1);

        int maxX1 = Math.max(ax1, bx1);
        int minX1 = Math.min(ax1, bx1);
        int maxX2 = Math.max(ax2, bx2);
        int minX2 = Math.min(ax2, bx2);

        int totalX = maxX2 - minX1;
        int overlapX = totalX - (maxX2 - minX2) - (maxX1 - minX1);

        return totalArea - (overlapX * overlapY);
    }
}
