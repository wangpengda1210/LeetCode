public class LargestBSTSubtree {
    class TreeNode {
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

    int largest = 0;
    public int largestBSTSubtree(TreeNode root) {
        findSubtree(root);
        return largest;
    }

    private int[] findSubtree(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1 };
        }

        int[] left = findSubtree(root.left);
        int[] right = findSubtree(root.right);

        if (left[3] == 0 || right[3] == 0) {
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0 };
        }

        int min = Math.min(left[0], root.val);
        int max = Math.max(right[1], root.val);

        if (root.val > left[1] && root.val < right[0]) {
            largest = Math.max(largest, left[2] + right[2] + 1);
            return new int[] { min, max, left[2] + right[2] + 1, 1 };
        }

        return new int[] { min, max, 0, 0 };
    }
}
