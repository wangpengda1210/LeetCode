import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    class Node {
        HashMap<Character, Node> children = new HashMap<>();
        int wordIndex = -1;
        ArrayList<Integer> remainPalindrome = new ArrayList<>();
    }

    private boolean isPalindrome(String s, int i) {
        int start = i;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversed = new StringBuilder(word).reverse().toString();
            Node curr = root;

            for (int j = 0; j < reversed.length(); j++) {
                if (isPalindrome(reversed, j)) {
                    curr.remainPalindrome.add(i);
                }

                char c = reversed.charAt(j);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
            }

            curr.wordIndex = i;
        }

        ArrayList<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            Node curr = root;
            for (int j = 0; j < word.length(); j++) {
                if (curr.wordIndex != -1 && isPalindrome(word, j)) {
                    pairs.add(Arrays.asList(i, curr.wordIndex));
                }

                char c = word.charAt(j);
                curr = curr.children.get(c);
                if (curr == null) {
                    break;
                }
            }

            if (curr == null) {
                continue;
            }

            if (curr.wordIndex != -1 && curr.wordIndex != i) {
                pairs.add(Arrays.asList(i, curr.wordIndex));
            }

            for (int index : curr.remainPalindrome) {
                pairs.add(Arrays.asList(i, index));
            }
        }

        return pairs;
    }
}
