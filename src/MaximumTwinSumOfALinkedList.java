import java.util.Stack;

public class MaximumTwinSumOfALinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return -1;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        Stack<Integer> nums = new Stack<>();
        while (fast.next != null) {
            nums.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        nums.push(slow.val);

        int max = 0;
        while (!nums.isEmpty()) {
            slow = slow.next;
            max = Math.max(max, slow.val + nums.pop());
        }

        return max;
    }
}
