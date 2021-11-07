import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        int thisLayer = 0;
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            if (thisLayer == 0) {
                thisLayer = nodes.size();
            }

            TreeNode current = nodes.poll();
            if (thisLayer == 1) {
                result.add(current.val);
            }

            if (current.left != null) {
                nodes.offer(current.left);
            }

            if (current.right != null) {
                nodes.offer(current.right);
            }

            thisLayer--;
        }

        return result;
    }
}
