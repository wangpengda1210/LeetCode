import java.util.HashSet;

public class TwoSumBST {
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

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> foundValues = new HashSet<>();
        return find(root, k, foundValues);
    }

    private boolean find(TreeNode root, int k, HashSet<Integer> foundValues) {
        if (root == null) {
            return false;
        }

        if (foundValues.contains(k - root.val)) {
            return true;
        }

        foundValues.add(root.val);

        return find(root.left, k, foundValues) || find(root.right, k, foundValues);
    }
}
