/**
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * <p>
 * We say s1[i] and s2[i] are equivalent characters.
 * <p>
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * <p>
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde",
 * "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 * <p>
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 */

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parents = new int[26];

        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(parents, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (find(parents, c - 'a') + 'a'));
        }

        return sb.toString();
    }

    private int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }

        return parents[i] = find(parents, parents[i]);
    }

    private void union(int[] parents, int x, int y) {
        int parentX = find(parents, x);
        int parentY = find(parents, y);

        if (parentX == parentY) {
            return;
        }

        if (parentX < parentY) {
            parents[parentY] = parentX;
        } else {
            parents[parentX] = parentY;
        }
    }
}
