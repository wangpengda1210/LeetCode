public class LowestCommonAncestorOfBinaryTree {
    class TreeNode {
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

    private TreeNode ans;

    public LowestCommonAncestorOfBinaryTree() {
        // Variable to store LCA node.
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p, q);
        return this.ans;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean findRight = findNode(root.right, p, q);
        boolean findLeft = findNode(root.left, p, q);
        boolean findThis = root == p || root == q;

        if (findRight && findLeft || findThis && findLeft || findThis && findRight) {
            this.ans = root;
        }

        return findRight || findLeft || findThis;
    }
}
