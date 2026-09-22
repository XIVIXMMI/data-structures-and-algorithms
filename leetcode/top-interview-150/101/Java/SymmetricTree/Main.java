public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: symmetric tree
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 4  3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("Test 1 (expect true): " + sol.isSymmetric(root1));

         // Test 2: not symmetric
        //     1
        //    / \
        //   2   2
        //    \   \
        //    3    3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println("Test 2 (expect false): " + sol.isSymmetric(root2));

        // Test 3: single node, no children
        //   1
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3 (expect true): " + sol.isSymmetric(root3));
    }
}
