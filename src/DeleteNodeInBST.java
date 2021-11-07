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
        TreeNode parent = root;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == key) {
                break;
            }

            if (curr.val > key) {
                parent = curr;
                curr = curr.left;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }

        if (curr == null) {
            return root;
        }

        return delete(root, parent, curr);
    }

    private TreeNode delete(TreeNode root, TreeNode parent, TreeNode curr) {
        if (curr.left == null && curr.right == null) {
            if (curr == root) {
                return null;
            }

            if (parent.right == curr) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } else if (curr.left == null) {
            if (curr == root) {
                return curr.right;
            }

            if (parent.right == curr) {
                parent.right = curr.right;
            } else {
                parent.left = curr.right;
            }
        } else if (curr.right == null) {
            if (curr == root) {
                return curr.left;
            }

            if (parent.right == curr) {
                parent.right = curr.left;
            } else {
                parent.left = curr.left;
            }
        } else {
            TreeNode minNode = curr.right;
            TreeNode minParent = curr;

            while (minNode.left != null) {
                minParent = minNode;
                minNode = minNode.left;
            }

            curr.val = minNode.val;
            delete(root, minParent, minNode);
        }

        return root;
    }
}
