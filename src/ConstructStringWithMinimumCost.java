import java.util.Arrays;

/**
 * You are given a string target, an array of strings words, and an integer array costs, both arrays of the same length.
 * <p>
 * Imagine an empty string s.
 * <p>
 * You can perform the following operation any number of times (including zero):
 * <p>
 * Choose an index i in the range [0, words.length - 1].
 * Append words[i] to s.
 * The cost of operation is costs[i].
 * Return the minimum cost to make s equal to target. If it's not possible, return -1.
 */

public class ConstructStringWithMinimumCost {
    static class TrieNode {
        TrieNode[] children;
        int cost;

        TrieNode() {
            children = new TrieNode[26];
            cost = Integer.MAX_VALUE;
        }
    }

    private void insert(TrieNode root, String word, int cost) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.cost = Math.min(current.cost, cost);
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], costs[i]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            TrieNode current = root;
            for (int j = i; j < n; j++) {
                int index = target.charAt(j) - 'a';
                if (current.children[index] == null) break;
                current = current.children[index];
                if (current.cost != Integer.MAX_VALUE) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + current.cost);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
