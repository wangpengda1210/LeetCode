public class ClosestBinarySearchTreeValue {
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

    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double closestDiff = Double.MAX_VALUE;

        TreeNode curr = root;
        while (curr != null) {
            int val = curr.val;
            double diff = Math.abs(val - target);
            if (diff < closestDiff || (diff == closestDiff && val < closest)) {
                closest = val;
                closestDiff = diff;
            }

            if (target < val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return closest;
    }
}
