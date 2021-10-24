public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedList = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedList[k] = nums1[i];
                i++;
            } else {
                mergedList[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mergedList[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            mergedList[k] = nums2[j];
            j++;
            k++;
        }

        System.arraycopy(mergedList, 0, nums1, 0, m + n);
    }
}
