import java.util.List;

public class LeftmostColumnWithAtLeastAOne {
    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
  }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = dimension.get(0);
        int col = dimension.get(1);

        int currRow = 0;
        int currCol = col - 1;
        int leftMostCol = -1;

        while (currCol >= 0 && currRow < row) {
            while (currCol >= 0 && binaryMatrix.get(currRow, currCol) == 1) {
                leftMostCol = currCol;
                currCol--;
            }

            while (currRow < row && currCol >= 0 && binaryMatrix.get(currRow, currCol) == 0) {
                currRow++;
            }
        }

        return leftMostCol;
    }
}
