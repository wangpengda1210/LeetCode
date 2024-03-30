public class MaximumAverageSubtree {
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

    double maxAverage = 0;
    public double maximumAverageSubtree(TreeNode root) {
        findMaxAverage(root);
        return maxAverage;
    }

    private double[] findMaxAverage(TreeNode root) {
        if (root == null) {
            return new double[] { 0, 0 };
        }

        double[] left = findMaxAverage(root.left);
        double[] right = findMaxAverage(root.right);

        double count = left[0] + right[0] + 1;
        double sum = left[1] + right[1] + root.val;

        maxAverage = Math.max(maxAverage, sum / count);
        return new double[] { count, sum };
    }
}
