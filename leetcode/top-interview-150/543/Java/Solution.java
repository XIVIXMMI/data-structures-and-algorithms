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

class Solution {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    int depth(TreeNode root) {

        if (root == null)
            return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        // update diameter at this node
        maxDiameter = Math.max(maxDiameter, left + right);

        // return depth to parent
        return Math.max(left,right) + 1;
    }
}