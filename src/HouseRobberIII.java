import java.util.HashMap;

public class HouseRobberIII {
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

    HashMap<TreeNode, Integer> canRobDict = new HashMap<>();
    HashMap<TreeNode, Integer> cannotRobDict = new HashMap<>();

    public int rob(TreeNode root) {
        return rob(root, true);
    }

    private int rob(TreeNode root, boolean canRob) {
        if (root == null) {
            return 0;
        }

        if (canRob) {
            if (canRobDict.containsKey(root)) {
                return canRobDict.get(root);
            }

            int rob = root.val + rob(root.left, false) + rob(root.right, false);
            int notRob = rob(root.left, true) + rob(root.right, true);

            int max = Math.max(rob, notRob);
            canRobDict.put(root, max);
            return max;
        } else {
            if (cannotRobDict.containsKey(root)) {
                return cannotRobDict.get(root);
            }

            int value = rob(root.left, true) + rob(root.right, true);
            cannotRobDict.put(root, value);
            return value;
        }
    }
}
