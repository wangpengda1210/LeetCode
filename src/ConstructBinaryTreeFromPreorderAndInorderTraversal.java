import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
        if (inStart > inEnd || preStart > preorder.length - 1) {
            return null;
        }

        int root = preorder[preStart];
        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                inIndex = i;
                break;
            }
        }

        return new TreeNode(root, helper(preorder, inorder, inStart, inIndex - 1, preStart + 1),
                helper(preorder, inorder, inIndex + 1, inEnd, preStart + inIndex - inStart + 1));
    }
}
