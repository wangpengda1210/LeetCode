import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Codec {
    class TreeNode {
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodeValues = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root == null ? new TreeNode(1001) : root);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.poll();
            if (current.val == 1001) {
                nodeValues.add("null");
            } else {
                nodeValues.add(String.valueOf(current.val));
                nodes.add(current.left == null ? new TreeNode(1001) : current.left);
                nodes.add(current.right == null ? new TreeNode(1001) : current.right);
            }
        }

        return nodeValues.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replaceAll("[\\[\\],]", "");

        String[] nodeValues = data.split(" ");

        if (nodeValues[0].equals("null")) {
            return null;
        }

        Queue<TreeNode> nodes = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        nodes.offer(root);

        int i = 1;
        while (i < nodeValues.length && !nodes.isEmpty()) {
            TreeNode nextNode = nodes.poll();
            if (!nodeValues[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeValues[i]));
                nextNode.left = leftNode;
                nodes.offer(leftNode);
            }

            if (i + 1 < nodeValues.length && !nodeValues[i + 1].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeValues[i + 1]));
                nextNode.right = rightNode;
                nodes.offer(rightNode);
            }

            i = i + 2;
        }

        return root;
    }
}
