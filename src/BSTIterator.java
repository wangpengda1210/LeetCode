import java.util.ArrayDeque;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    Queue<TreeNode> nodes;
    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();

        addAll(root);
    }

    public int next() {
        return nodes.poll().val;
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    private void addAll(TreeNode root) {
        if (root != null) {
            addAll(root.left);
            nodes.offer(root);
            addAll(root.right);
        }
    }
}
