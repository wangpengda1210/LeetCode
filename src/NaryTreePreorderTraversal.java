import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();

        if (root == null) {
            return answer;
        }

        preorder(root, answer);

        return answer;
    }

    private void preorder(Node root, List<Integer> list) {
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
    }
}
