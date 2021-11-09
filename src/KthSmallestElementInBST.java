import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    // Definition for a binary tree node.
    public class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        find(root, k, nodes);
        return nodes.get(k - 1);
    }

    private void find(TreeNode root, int k, List<Integer> nodes) {
        if (nodes.size() >= k) {
            return;
        }

        if (root == null) {
            return;
        }

        find(root.left, k, nodes);
        nodes.add(root.val);
        find(root.right, k, nodes);
    }
}
