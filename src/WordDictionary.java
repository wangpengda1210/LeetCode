import java.util.HashMap;

public class WordDictionary {
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

    public WordDictionary() {
        this.root = new Node();
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

    public boolean search(String word) {
        return searchNode(word, root);
    }

    public boolean searchNode(String word, Node node) {
        Node curr = node;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char child : curr.children.keySet()) {
                    if (searchNode(word.substring(i + 1), curr.children.get(child))) {
                        return true;
                    }
                }

                return false;
            } else if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return curr.isEnd;
    }
}
