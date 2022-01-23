import java.util.*;

public class WordSearchII {
    class Node {
        HashMap<Character, Node> children;
        String word;

        public Node() {
            children = new HashMap<>();
            word = null;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    Node root = new Node();

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }

        curr.setWord(word);
    }

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            addWord(word);
        }

        Set<String> found = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    findWord(board, found, root.children.get(board[i][j]), i, j);
                }
            }
        }

        return new ArrayList<>(found);
    }

    private void findWord(char[][] board, Set<String> found, Node curr, int i, int j) {
        if (curr.getWord() != null) {
            found.add(curr.getWord());
        }

        char currChar = board[i][j];
        board[i][j] = '1';

        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[0].length) {
                continue;
            }

            if (curr.children.containsKey(board[newI][newJ])) {
                findWord(board, found, curr.children.get(board[newI][newJ]), newI, newJ);
            }
        }

        board[i][j] = currChar;
    }
}
