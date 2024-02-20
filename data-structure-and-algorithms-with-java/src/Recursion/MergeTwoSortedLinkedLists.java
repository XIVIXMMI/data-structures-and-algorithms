package Recursion;

public class MergeTwoSortedLinkedLists {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(15);
        Node n3 = new Node(13);
        Node n4 = new Node(14);
        Node n5 = new Node(550);

        Node n1_1 = new Node(2);
        Node n2_2 = new Node(15);
        Node n3_3 = new Node(130);
        Node n4_4 = new Node(200);
        Node n5_5 = new Node(350);

        n1_1.next = n2_2;
        n2_2.next = n3_3;
        n3_3.next = n4_4;
        n4_4.next = n5_5;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node mergeList = sortedMerge(n1, n1_1);
        printLinkedList(mergeList);
    }

    public static Node sortedMerge(Node A, Node B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        if (A.data < B.data) {
            A.next = sortedMerge(A.next, B);
            return A;
        } else {
            B.next = sortedMerge(A, B.next);
            return B;
        }
    }

    private static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
