package LinkedListCycle;

import java.util.HashSet;

public class Solution {
    // time complexity o(n)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> cycleDetector = new HashSet<>();

        ListNode currentNode = head;

        while (currentNode != null) {

            // if add false -> cycle detect! -> return return true immediate
            if (!cycleDetector.add(currentNode)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }


    // Floyd's cycle detection 
    public boolean hasCycleTwoPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast) {
                return true;
            }
        }
        return false;
    }
}
