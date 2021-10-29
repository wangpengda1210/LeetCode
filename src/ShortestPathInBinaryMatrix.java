import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private class Index {
        int row;
        int col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        Queue<Index> cells = new ArrayDeque<>();
        addCell(cells, grid, n, 0, 0);
        int length = 0;
        int cellThisLayer = 0;

        while (true) {
            if (cellThisLayer == 0) {
                cellThisLayer = cells.size();
                length++;
            }

            Index nextCell = cells.poll();
            if (nextCell != null) {
                int nextRow = nextCell.row;
                int nextCol = nextCell.col;

                if (grid[nextRow][nextCol] == 0) {
                    if (nextRow == n - 1 && nextCol == n - 1) {
                        return length;
                    }

                    addCell(cells, grid, n, nextRow - 1, nextCol - 1);
                    addCell(cells, grid, n, nextRow - 1, nextCol);
                    addCell(cells, grid, n, nextRow - 1, nextCol + 1);
                    addCell(cells, grid, n, nextRow, nextCol - 1);
                    addCell(cells, grid, n, nextRow, nextCol + 1);
                    addCell(cells, grid, n, nextRow + 1, nextCol - 1);
                    addCell(cells, grid, n, nextRow + 1, nextCol);
                    addCell(cells, grid, n, nextRow + 1, nextCol + 1);
                }

                grid[nextRow][nextCol] = 1;
            } else {
                return -1;
            }

            cellThisLayer--;
        }
    }

    private void addCell(Queue<Index> cells, int[][] grid, int n, int row, int col) {
        if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] != 1) {
            cells.offer(new Index(row, col));
        }
    }
}
