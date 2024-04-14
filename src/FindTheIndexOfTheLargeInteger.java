public class FindTheIndexOfTheLargeInteger {
    public interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        int compareSub(int l, int r, int x, int y);

        // Returns the length of the array
        int length();
    }

    public int getIndex(ArrayReader reader) {
        int n = reader.length();

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cmp = (right - left) % 2 == 0 ? reader.compareSub(left, mid, mid, right) : reader.compareSub(left, mid, mid + 1, right);

            if (cmp == 0) {
                return mid;
            }

            if (cmp == -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
