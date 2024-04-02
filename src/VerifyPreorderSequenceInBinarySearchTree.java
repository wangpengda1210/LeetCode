import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
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

    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> monoStack = new Stack<>();

        for (int node : preorder) {
            while (!monoStack.isEmpty() && node > monoStack.peek()) {
                min = monoStack.pop();
            }

            if (node <= min) {
                return false;
            }

            monoStack.push(node);
        }

        return true;
    }
}
