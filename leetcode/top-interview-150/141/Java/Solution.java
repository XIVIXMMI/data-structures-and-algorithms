import java.util.HashSet;

public class Solution {
    
    public static void main(String[] args) {
        // Test 1: List with a cycle (4 -> 2)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next; // cycle back to node 2
        System.out.println("Test 1 (expect true):  " + hasCycle(head1) + " " + hasCycle_hashSet(head1));

        // Test 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("Test 2 (expect false): " + hasCycle(head2) + " " + hasCycle_hashSet(head2));
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

    public static boolean hasCycle_hashSet(ListNode head){
        HashSet<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if( seen.contains(current)){
                return true;
            }
            seen.add(current);
            current = current.next;
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
