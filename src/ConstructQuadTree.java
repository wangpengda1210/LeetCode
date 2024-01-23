public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return constructNode(grid, 0, 0, grid.length);
    }

    private Node constructNode(int[][] grid, int i, int j, int length) {
        if (length == 1) {
            return new Node(grid[i][j] == 1, true);
        }

        Node curr = new Node(false, false);
        curr.topLeft = constructNode(grid, i, j, length / 2);
        curr.topRight = constructNode(grid, i, j + length / 2, length / 2);
        curr.bottomLeft = constructNode(grid, i + length / 2, j, length / 2);
        curr.bottomRight = constructNode(grid, i + length / 2, j + length / 2, length / 2);

        if (curr.topLeft.isLeaf && curr.topRight.isLeaf && curr.bottomLeft.isLeaf && curr.bottomRight.isLeaf &&
            curr.topLeft.val == curr.topRight.val && curr.topLeft.val == curr.bottomLeft.val && curr.topLeft.val == curr.bottomRight.val) {
            curr.val = curr.topLeft.val;
            curr.isLeaf = true;
            curr.topLeft = null;
            curr.topRight = null;
            curr.bottomLeft = null;
            curr.bottomRight = null;
        }

        return curr;
    }
}
