public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (m < n) {
            return -1;
        }

        int[] border = new int[n];
        int i = 1;
        int prev = 0;

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(prev)) {
                prev++;
                border[i] = prev;
                i++;
            } else if (prev == 0) {
                border[i] = 0;
                i++;
            } else {
                prev = border[prev - 1];
            }
        }

        int pHaystack = 0;
        int pNeedle = 0;
        while (pHaystack < m) {
            if (haystack.charAt(pHaystack) == needle.charAt(pNeedle)) {
                pHaystack++;
                pNeedle++;

                if (pNeedle >= n) {
                    return pHaystack - n;
                }
            } else {
                if (pNeedle == 0) {
                    pHaystack++;
                } else {
                    pNeedle = border[pNeedle - 1];
                }
            }
        }

        return -1;
    }
}
