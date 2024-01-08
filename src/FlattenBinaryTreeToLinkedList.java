public class FlattenBinaryTreeToLinkedList {
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

    public void flatten(TreeNode root) {
        find(root);
    }

    private TreeNode find(TreeNode root) {
        if (root == null) return null;

        TreeNode leftRightMost = find(root.left);
        TreeNode rightRightMost = find(root.right);
        if (leftRightMost != null) {
            leftRightMost.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightRightMost == null ? leftRightMost == null ? root : leftRightMost : rightRightMost;
    }
}
