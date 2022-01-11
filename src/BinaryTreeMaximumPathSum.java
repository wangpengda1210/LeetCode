public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = Math.max(maxPath(root.left), 0);
        int maxRight = Math.max(maxPath(root.right), 0);

        if (root.val + maxLeft + maxRight > max) {
            max = root.val + maxLeft + maxRight;
        }

        return root.val + Math.max(maxLeft, maxRight);
    }
}
