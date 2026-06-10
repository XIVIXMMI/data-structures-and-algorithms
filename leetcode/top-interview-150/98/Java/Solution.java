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
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validate(TreeNode root, long min, long max) {
        if(root == null) return true; // base case empty node is valid
        if(root.val <= min || root.val >= max) return false;
        return validate(root.right, root.val, max)  // floor goes up
            && validate(root.left, min, root.val); // ceilling gose down
    }
}