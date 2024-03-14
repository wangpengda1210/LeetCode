import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }

        public void setWord() {
            this.isWord = true;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        for (String product : products) {
            TrieNode curr = root;
            for (char c : product.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.setWord();
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            ArrayList<String> currSuggest = new ArrayList<>();

            if (curr != null) {
                curr = curr.children[c - 'a'];
                if (curr != null) {
                    prefix.append(c);
                    dfs(currSuggest, prefix, curr);
                }
            }

            result.add(currSuggest);
        }

        return result;
    }

    private void dfs(ArrayList<String> currSuggest, StringBuilder prefix, TrieNode curr) {
        if (currSuggest.size() >= 3) {
            return;
        }

        if (curr.isWord) {
            currSuggest.add(prefix.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                prefix.append((char) ('a' + i));
                dfs(currSuggest, prefix, curr.children[i]);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}
