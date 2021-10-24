import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> untraveledNodes = new ArrayDeque<>();
        untraveledNodes.offer(root);
        int thisLevel = 0;
        int nextLevel = 1;
        List<Integer> level = new ArrayList<>();

        while (!untraveledNodes.isEmpty()) {
            if (thisLevel == 0) {
                thisLevel = nextLevel;
                nextLevel = 0;
                result.add(level);
                level = new ArrayList<>();
            }

            TreeNode thisNode = untraveledNodes.poll();
            level.add(thisNode.val);
            if (thisNode.left != null) {
                untraveledNodes.offer(thisNode.left);
                nextLevel++;
            }
            if (thisNode.right != null) {
                untraveledNodes.offer(thisNode.right);
                nextLevel++;
            }
            thisLevel--;
        }

        result.add(level);
        result.remove(0);
        return result;
    }
}
