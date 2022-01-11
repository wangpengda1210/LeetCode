public class DeleteLeavesWithAGivenValue {
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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        remove(root, target);
        return root.val == 0 ? null : root;
    }

    private void remove(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        remove(root.left, target);
        remove(root.right, target);

        if (root.left != null && root.left.val == 0) {
            root.left = null;
        }

        if (root.right != null && root.right.val == 0) {
            root.right = null;
        }

        if (root.right == null && root.left == null && root.val == target) {
            root.val = 0;
        }
    }
}
