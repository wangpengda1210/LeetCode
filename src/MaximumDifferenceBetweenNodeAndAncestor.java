public class MaximumDifferenceBetweenNodeAndAncestor {
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

    public int maxAncestorDiff(TreeNode root) {
        return treeMinMax(root)[2];
    }

    private int[] treeMinMax(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return new int[] {root.val, root.val, 0};
        }

        int[] left = treeMinMax(root.left);
        int[] right = treeMinMax(root.right);
        int min = root.val;
        int max = root.val;
        int sub = 0;

        if (left != null) {
            min = Math.min(min, left[0]);
            max = Math.max(max, left[1]);
            sub = Math.max(sub, Math.abs(left[0] - root.val));
            sub = Math.max(sub, Math.abs(left[1] - root.val));
            sub = Math.max(sub, left[2]);
        }

        if (right != null) {
            min = Math.min(min, right[0]);
            max = Math.max(max, right[1]);
            sub = Math.max(sub, Math.abs(right[0] - root.val));
            sub = Math.max(sub, Math.abs(right[1] - root.val));
            sub = Math.max(sub, right[2]);
        }

        return new int[] { min, max, sub };
    }
}
