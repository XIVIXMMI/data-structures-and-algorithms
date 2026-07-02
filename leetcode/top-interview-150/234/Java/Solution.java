import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> arr = arrayConverter(head);
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            if (arr.get(left).equals(arr.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;
    }

    public static List<Integer> arrayConverter(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return arr;
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
