package Recursion;

import java.util.List;

public class Trees {

    public static class Node {
        private int val;
        private Node left; // Change 'next' to 'left' for the left child
        private Node right; // Add 'right' for the right child

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public Node getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        List<Integer> dataInput = List.of(100, 80, 50, 90, 30, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);
        Node root = null;
        for (Integer node : dataInput) {
            root = insertNode(root, node);
        }
        printLeaves(root);
    }

    public static Node insertNode(Node root, int val) {
        if (root == null) {
            Node newNode = new Node(val);
            return newNode;
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val); // Fix: Change 'root.left' to 'root.right'
        }
        return root;
    }

    public static void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        // check if a given node is a leaf
        if (root.left == null && root.right == null) {
            System.out.print(root.val + ", ");
            return;
        }
        if (root.left != null)
            printLeaves(root.left);
        if (root.right != null) // Fix: Change 'root.right == null' to 'root.right != null'
            printLeaves(root.right);
    }
}
