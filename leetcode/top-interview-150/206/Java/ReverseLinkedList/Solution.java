package ReverseLinkedList;

public class Solution {
    public ListNode reverseList(ListNode head) {

        if( head == null) return null;
        if( head.next == null ) return head;
        
        ListNode newNode = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return newNode;
    }


}