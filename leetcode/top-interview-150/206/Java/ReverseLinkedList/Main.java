package ReverseLinkedList;

public class Main {

    private static Solution solution = new Solution();

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original: ");
        printList(head);

        ListNode reversed = solution.reverseList(head);

        System.out.print("Reversed: ");
        printList(reversed);
    }
}
