public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isNodeBalanced(root) != -1;
    }

    private int isNodeBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTree = isNodeBalanced(root.left);
        if (leftTree == -1) {
            return -1;
        }

        int rightTree = isNodeBalanced(root.right);
        if (rightTree == -1) {
            return -1;
        }

        if (Math.abs(leftTree - rightTree) < 2) {
            return Math.max(leftTree, rightTree) + 1;
        }

        return -1;
    }
}
