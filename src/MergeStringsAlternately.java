public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        char[] merged = new char[l1 + l2];
        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while (p1 < l1 && p2 < l2) {
            merged[p] = word1.charAt(p1);
            p++;
            merged[p] = word2.charAt(p2);
            p1++;
            p2++;
            p++;
        }

        while (p1 < l1) {
            merged[p] = word1.charAt(p1);
            p++;
            p1++;
        }

        while (p2 < l2) {
            merged[p] = word2.charAt(p2);
            p++;
            p2++;
        }

        return String.valueOf(merged);
    }
}
