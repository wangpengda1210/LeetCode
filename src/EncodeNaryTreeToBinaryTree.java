import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EncodeNaryTreeToBinaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getKey() {
            return t;
        }

        public S getValue() {
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }

            Queue<Pair<Node, TreeNode>> nodes = new LinkedList<>();
            TreeNode newRoot = new TreeNode(root.val);
            nodes.offer(new Pair<>(root, newRoot));

            while (!nodes.isEmpty()) {
                Pair<Node, TreeNode> next = nodes.poll();
                Node node = next.getKey();
                TreeNode newNode = next.getValue();

                TreeNode newHead = null;
                TreeNode newCurr = null;
                for (Node child : node.children) {
                    if (newHead == null) {
                        newHead = new TreeNode(child.val);
                        newCurr = newHead;
                    } else {
                        newCurr.right = new TreeNode(child.val);
                        newCurr = newCurr.right;
                    }
                    nodes.add(new Pair<>(child, newCurr));
                }
                newNode.left = newHead;
            }

            return newRoot;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }

            Node newRoot = new Node(root.val, new ArrayList<>());
            Queue<Pair<TreeNode, Node>> nodes = new LinkedList<>();
            nodes.add(new Pair<>(root, newRoot));

            while (!nodes.isEmpty()) {
                Pair<TreeNode, Node> next = nodes.poll();
                TreeNode node = next.getKey();
                Node newNode = next.getValue();

                TreeNode child = node.left;
                while (child != null) {
                    Node newChild = new Node(child.val, new ArrayList<>());
                    newNode.children.add(newChild);
                    nodes.add(new Pair<>(child, newChild));
                    child = child.right;
                }
            }

            return newRoot;
        }
    }
}
