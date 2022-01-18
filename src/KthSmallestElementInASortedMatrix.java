public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;

            int count = 0;
            int largestLess = start;
            int smallestMore = end;

            int row = n - 1;
            int col = 0;

            while (row >= 0 && col < n) {
                if (matrix[row][col] <= mid) {
                    largestLess = Math.max(largestLess, matrix[row][col]);
                    count += row + 1;
                    col++;
                } else {
                    smallestMore = Math.min(smallestMore, matrix[row][col]);
                    row--;
                }
            }

            if (count == k) {
                return largestLess;
            }

            if (count < k) {
                start = smallestMore;
            } else {
                end = largestLess;
            }
        }

        return start;
    }
}
