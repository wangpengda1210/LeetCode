public class SubtreeOfAnotherTree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (equalTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equalTree(TreeNode tree1, TreeNode tree2) {
          if (tree1 == null && tree2 == null) {
              return true;
          }
          if (tree1 == null || tree2 == null) {
              return false;
          }

          if (tree1.val != tree2.val) {
              return false;
          }

          return equalTree(tree1.left, tree2.left) && equalTree(tree1.right, tree2.right);
    }
}
