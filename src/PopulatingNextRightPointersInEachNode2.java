import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {
// Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);
        int nodesThisLevel = 0;

        while (!nodes.isEmpty()) {
            if (nodesThisLevel == 0) {
                nodesThisLevel = nodes.size();
            }

            Node nextNode = nodes.poll();
            if (nodesThisLevel == 1) {
                nextNode.next = null;
            } else {
                nextNode.next = nodes.peek();
            }
            nodesThisLevel--;

            if (nextNode.left != null) {
                nodes.offer(nextNode.left);
            }

            if (nextNode.right != null) {
                nodes.offer(nextNode.right);
            }
        }

        return root;
    }
}
