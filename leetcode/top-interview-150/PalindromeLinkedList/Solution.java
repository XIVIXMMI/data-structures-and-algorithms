import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPalindrome_subArray(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (!nums.get(left).equals(nums.get(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode node = head; // first half
        ListNode middle = findMiddle(node);

        ListNode secondHalfReversed = revertListNode(middle); // second half

        while (secondHalfReversed != null) {
            if(head.val != secondHalfReversed.val) return false;
        
            head = head.next;
            secondHalfReversed = secondHalfReversed.next;
        }

        return true;
    }

    // làm cách nào tìm được node giữa của linkedList mà không cần biết trước độ dài
    private ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    // sau khi có node giữa cần làm gì với nửa sau của linkedList để so sánh nó với
    // nửa đầu tiên mà không cần mảng phụ

    // đảo ngược 1 phần của list
    private ListNode revertListNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next; // store next node

            curr.next = prev; // reverse's pointer
            prev = curr; // prev ++ 
            curr = next; // curr ++
        }

        return prev;
    }
}
