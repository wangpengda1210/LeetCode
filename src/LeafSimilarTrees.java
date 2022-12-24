import java.util.ArrayList;

public class LeafSimilarTrees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();

        getLeafList(root1, leaf1);
        getLeafList(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    private void getLeafList(TreeNode root, ArrayList<Integer> leaf) {
        if (root == null) {
            return;
        }

        getLeafList(root.left, leaf);

        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }

        getLeafList(root.right, leaf);
    }
}
