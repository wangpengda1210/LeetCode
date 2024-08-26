/**
 * Two strings, X and Y, are considered similar if either they are identical
 * or we can make them equivalent by swapping at most two letters (in distinct positions) within the string X.
 * <p>
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
 * but "star" is not similar to "tars", "rats", or "arts".
 * <p>
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
 * Notice that "tars" and "arts" are in the same group even though they are not similar.
 * Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * <p>
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?
 */

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int[] parents = new int[strs.length];
        int[] sizes = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }


        for (int i = 0; i < strs.length - 1; i++) {
            String first = strs[i];
            for (int j = i + 1; j < strs.length; j++) {
                String second = strs[j];
                if (isSimilar(first, second)) {
                    union(parents, sizes, i, j);
                }
            }
        }

        int groups = 0;
        for (int i = 0; i < strs.length; i++) {
            if (parents[i] == i) {
                groups++;
            }
        }

        return groups;
    }

    private boolean isSimilar(String x, String y) {
        int diffs = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diffs++;
                if (diffs > 2) {
                    return false;
                }
            }
        }

        return diffs == 0 || diffs == 2;
    }

    private int find(int[] parents, int i) {
        if (i == parents[i]) {
            return i;
        }

        return parents[i] = find(parents, parents[i]);
    }

    private void union(int[] parents, int[] sizes, int x, int y) {
        int xParent = find(parents, x);
        int yParent = find(parents, y);

        if (xParent == yParent) {
            return;
        }

        if (sizes[xParent] > sizes[yParent]) {
            parents[yParent] = xParent;
            sizes[xParent] += sizes[yParent];
        } else {
            parents[xParent] = yParent;
            sizes[yParent] += sizes[xParent];
        }
    }
}
