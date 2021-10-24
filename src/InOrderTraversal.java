import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes;
    }

    public void traverse (TreeNode root, List<Integer> nodes) {
        if (root != null) {
            traverse(root.left, nodes);
            nodes.add(root.val);
            traverse(root.right, nodes);
        }
    }
}
