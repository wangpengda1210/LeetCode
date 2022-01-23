import java.util.HashMap;

public class LongestWordWithAllPrefixes {
    class Trie {
        class Node {
            HashMap<Character, Node> children;
            boolean isEnd;

            public Node() {
                children = new HashMap<>();
                isEnd = false;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }
        }

        Node root;
        public Trie() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
            }

            curr.setEnd(true);
        }

        public boolean hasWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }

            return curr.isEnd;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        String longestWord = "";
        for (String word : words) {
            if (word.length() < longestWord.length()) {
                continue;
            }

            boolean hasAllPrefix = true;
            for (int i = 1; i < word.length(); i++) {
                if (!trie.hasWord(word.substring(0, i))) {
                    hasAllPrefix = false;
                    break;
                }
            }

            if (hasAllPrefix) {
                if (word.length() > longestWord.length() || word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
}
