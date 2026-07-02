class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) 
            return false;

        TreeNode node = root;
        
        if(node.left == null && node.right == null){
            int value = node.val;
            if( targetSum - value == 0){
                return true;
            } 
        }

        if(node.left != null || node.right != null){
            return hasPathSum(node.left, targetSum - node.val) || 
                    hasPathSum(node.right, targetSum - node.val);
        }

        return false;
    }
}

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