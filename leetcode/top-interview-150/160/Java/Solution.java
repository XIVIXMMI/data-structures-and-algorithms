import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> seen = new HashSet<>();
        while (headA != null) {
            seen.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (seen.contains(headB)) {
                return headB;
            }
            seen.add(headB);
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode_TwoPointers(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while( pA != pB){
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
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
}
