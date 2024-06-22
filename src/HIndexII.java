/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations
 * is sorted in ascending order, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia:
 * The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * You must write an algorithm that runs in logarithmic time.
 */

public class HIndexII {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= citations.length - mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return citations.length - start;
    }
}
