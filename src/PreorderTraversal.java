import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes;
    }

    public void traverse (TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            traverse(root.left, nodes);
            traverse(root.right, nodes);
        }
    }
}
