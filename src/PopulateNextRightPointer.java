import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PopulateNextRightPointer {
    public class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        ArrayList<Node> nodes = new ArrayList<>();
        Queue<Node> nodesSeen = new ArrayDeque<>();

        if (root != null) {
            nodesSeen.offer(root);
        }

        BFS(nodes, nodesSeen);

        int row = 1;
        int nodeInRow = 1;

        for (int i = 0; i < nodes.size() - 1; i++) {
            if ((int)Math.pow(2, (row - 1)) == nodeInRow) {
                row++;
                nodeInRow = 1;
                nodes.get(i).next = null;
            } else {
                nodes.get(i).next = nodes.get(i + 1);
                nodeInRow++;
            }
        }

        return root;
    }

    private void BFS(ArrayList<Node> nodesSoFar, Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node nodeToSeen = queue.poll();
            nodesSoFar.add(nodeToSeen);
            if (nodeToSeen.left != null) {
                queue.offer(nodeToSeen.left);
            }
            if (nodeToSeen.right != null) {
                queue.offer(nodeToSeen.right);
            }
        }
    }
}
