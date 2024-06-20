/**
 * You have a sorted array of unique elements and an unknown size.
 * You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
 * <p>
 * returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
 * returns 2^(31) - 1 if the i is out of the boundary of the array.
 * You are also given an integer target.
 * <p>
 * Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInASortedArrayOfUnknownSize {
     interface ArrayReader {
        public int get(int index);
     }

    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        while (reader.get(end) < target) {
            start = end;
            end *= 2;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int num = reader.get(mid);
            if (num == target) {
                return mid;
            }

            if (num < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
