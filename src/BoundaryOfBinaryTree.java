import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
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

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBound = new ArrayList<>();
        List<Integer> rightBound = new ArrayList<>();
        findBoundary(root, leftBound, rightBound, false, false, true);
        leftBound.addAll(rightBound);
        return leftBound;
    }

    private void findBoundary(TreeNode root, List<Integer> leftBound, List<Integer> rightBound,
                              boolean isLeftBoundary, boolean isRightBoundary, boolean isRoot) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leftBound.add(root.val);
        } else if (isLeftBoundary || isRoot) {
            leftBound.add(root.val);
        } else if (isRightBoundary) {
            rightBound.add(0, root.val);
        }

        findBoundary(root.left, leftBound, rightBound, isLeftBoundary || isRoot,
                isRightBoundary && root.right == null, false);
        findBoundary(root.right, leftBound, rightBound, isLeftBoundary && root.left == null,
                isRightBoundary || isRoot, false);
    }
}
