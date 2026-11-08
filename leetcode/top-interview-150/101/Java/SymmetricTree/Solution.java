public class Solution {
    public boolean isSymmetric(TreeNode root) {

        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if( left == null && right == null ) return true;

        if( left != null && right == null || left == null && right != null ) return false;

        if( left.val != right.val ) return false;

        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}


/*

root -> root.next.left compare to root.next.right && root.next.right compare to root.next.left

root.next.right == null && root.left.right == null -> return true;

root.next.right != null && root.next.left == null || root.next.right == null && root.next.left != null -> return false;

need to check two nodes together at every steps

-> a helper fuction takes two node and compare them 
*/
