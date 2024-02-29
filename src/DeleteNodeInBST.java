public class DeleteNodeInBST {
    // Definition for a binary tree node.
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                TreeNode curr = root.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                root.val = curr.val;
                root.left = deleteNode(root.left, root.val);
            } else {
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                root.val = curr.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }
}
