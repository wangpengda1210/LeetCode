public class Trie {
    class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }

        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }

        public Node get(char c) {
            return children[c - 'a'];
        }

        public void put(char c) {
            if (!containsKey(c)) {
                children[c - 'a'] = new Node();
            }
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
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            curr.put(c);
            curr = curr.get(c);
        }

        curr.setEnd(true);
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.containsKey(c)) {
                return false;
            }
            curr = curr.get(c);
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            if (!curr.containsKey(c)) {
                return false;
            }
            curr = curr.get(c);
        }

        return true;
    }
}