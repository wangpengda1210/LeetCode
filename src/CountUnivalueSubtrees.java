public class CountUnivalueSubtrees {
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

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnivalSubtree(root);
        return count;
    }

    private boolean isUnivalSubtree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeft = isUnivalSubtree(root.left);
        boolean isRight = isUnivalSubtree(root.right);

        if (isLeft && isRight) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }
            if (root.right != null && root.right.val != root.val) {
                return false;
            }
            count++;
            return true;
        }

        return false;
    }
}
