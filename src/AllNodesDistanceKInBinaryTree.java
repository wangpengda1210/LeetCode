import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, ArrayList<Integer>> neighbours = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findNeighbour(root);

        int layer = -1;
        int layerCount = 0;

        Queue<Integer> nodes = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();

        nodes.offer(target.val);
        seen.add(target.val);

        while (!nodes.isEmpty()) {
            if (layerCount == 0) {
                layerCount = nodes.size();
                layer++;

                if (layer == k) {
                    List<Integer> result = new ArrayList<>();
                    while (!nodes.isEmpty()) {
                        result.add(nodes.poll());
                    }

                    return result;
                }
            }

            List<Integer> next = neighbours.get(nodes.poll());
            for (int n : next) {
                if (!seen.contains(n)) {
                    nodes.offer(n);
                    seen.add(n);
                }
            }
            layerCount--;
        }

        return new ArrayList<>();
    }

    private void findNeighbour(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> neighbour = neighbours.getOrDefault(root.val, new ArrayList<>());

        if (root.left != null) {
            ArrayList<Integer> neighbourLeft = neighbours.getOrDefault(root.left.val, new ArrayList<>());
            neighbourLeft.add(root.val);
            neighbour.add(root.left.val);

            neighbours.put(root.left.val, neighbourLeft);
        }

        if (root.right != null) {
            ArrayList<Integer> neighbourRight = neighbours.getOrDefault(root.right.val, new ArrayList<>());
            neighbourRight.add(root.val);
            neighbour.add(root.right.val);

            neighbours.put(root.right.val, neighbourRight);
        }

        neighbours.put(root.val, neighbour);

        findNeighbour(root.left);
        findNeighbour(root.right);
    }
}
