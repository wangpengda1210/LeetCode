public class NumberOfShipsInARectangle {
    interface Sea {
      public boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0];
        int y1 = bottomLeft[1];
        int x2 = topRight[0];
        int y2 = topRight[1];

        if (x1 > x2 || y1 > y2) {
            return 0;
        }

        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (x1 == x2 && y1 == y2) {
            return 1;
        }

        int xMid = (x1 + x2) / 2;
        int yMid = (y1 + y2) / 2;

        return countShips(sea, new int[] {xMid, y2}, new int[] {x1, yMid + 1}) +
                countShips(sea, topRight, new int[] {xMid + 1, yMid + 1}) +
                countShips(sea, new int[] {xMid, yMid}, bottomLeft) +
                countShips(sea, new int[] {x2, yMid}, new int[] {xMid + 1, y1});
    }
}
