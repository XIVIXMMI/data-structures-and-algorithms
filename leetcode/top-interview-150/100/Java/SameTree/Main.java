public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test 1 (expect true): " + sol.isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test 2 (expect false): " + sol.isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q3 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Test 3 (expect false): " + sol.isSameTree(p3, q3));

        System.out.println("Test 4 (expect true): " + sol.isSameTree(null, null));

        TreeNode p5 = new TreeNode(1);
        System.out.println("Test 5 (expect false): " + sol.isSameTree(p5, null));
    }
}
