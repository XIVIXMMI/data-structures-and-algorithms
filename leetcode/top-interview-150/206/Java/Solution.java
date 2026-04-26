class Solution {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            // Save next
            next = curr.next;
            // Reverse pointer
            curr.next = prev;
            // Move
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        // Reverse
        ListNode reversed = reverseList(head);

        System.out.print("Reversed: ");
        printList(reversed);
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
