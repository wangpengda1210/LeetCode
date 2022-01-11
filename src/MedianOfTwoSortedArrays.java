public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (n < m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempInt = m;
            m = n;
            n = tempInt;
        }

        int left = 0;
        int right = m;
        while (true) {
            int mid1 = (left + right) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            if (mid2 > 0 && mid1 < m && nums2[mid2 - 1] > nums1[mid1]) {
                left = mid1 + 1;
            } else if (mid1 > 0 && mid2 < n && nums1[mid1 - 1] > nums2[mid2]) {
                right = mid1 - 1;
            } else {
                int midFirst;
                if (mid1 == 0) {
                    midFirst = nums2[mid2 - 1];
                } else if (mid2 == 0) {
                    midFirst = nums1[mid1 - 1];
                } else {
                    midFirst = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                }

                if ((m + n) % 2 == 0) {
                    return midFirst;
                } else {
                    int midSecond;
                    if (mid1 == m) {
                        midSecond = nums2[mid2];
                    } else if (mid2 == n) {
                        midSecond = nums1[mid1];
                    } else {
                        midSecond = Math.min(nums1[mid1], nums2[mid2]);
                    }

                    return (midFirst + midSecond) / 2.0;
                }
            }
        }
    }
}
