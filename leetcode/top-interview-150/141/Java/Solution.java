public class Solution {
    
    public static void main(String[] args) {
        // Test 1: List with a cycle (4 -> 2)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next; // cycle back to node 2
        System.out.println("Test 1 (expect true):  " + hasCycle(head1));

        // Test 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("Test 2 (expect false): " + hasCycle(head2));

        // Test 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test 3 (expect false): " + hasCycle(head3));

        // Test 4: Empty list
        System.out.println("Test 4 (expect false): " + hasCycle(null));

        // Test 5: Two nodes with cycle
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = head5; // cycle back to head
        System.out.println("Test 5 (expect true):  " + hasCycle(head5));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next; // move 1 step
            fast = fast.next.next; // move 2 steps

            if (slow == fast){
                return true;
            }
        }

        return false;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null; 
        }
    }
}
