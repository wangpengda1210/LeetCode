/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class AddTwoNumbersII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return reverseList(head.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
