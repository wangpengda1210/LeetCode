public class DiameterOfBinaryTree {
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

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfNode(root);
        return diameter;
    }

    private int diameterOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPath = diameterOfNode(node.left);
        int rightPath = diameterOfNode(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
