package LinkedListCycle;

public class Main {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        // Test 1: List with a cycle (4 -> 2)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next; // cycle back to node 2
        System.out.println("Test 1 (expect true):  " + solution.hasCycle(head1));

        // Test 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("Test 2 (expect false): " + solution.hasCycle(head2));
    }
}
