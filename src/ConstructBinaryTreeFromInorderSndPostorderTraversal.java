import java.util.HashMap;

public class ConstructBinaryTreeFromInorderSndPostorderTraversal {
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

    HashMap<Integer, Integer> inorderPos;
    int postPos;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderPos = new HashMap<>();
        postPos = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[postPos];
        int inPos = inorderPos.get(rootVal);
        postPos--;

        TreeNode root = new TreeNode(rootVal);
        TreeNode right = build(inorder, postorder, inPos + 1, end);

        root.left = build(inorder, postorder, start, inPos - 1);
        root.right = right;

        return root;
    }
}
