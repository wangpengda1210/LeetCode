public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode slow = head;
        int n = 0;
        while (slow != null) {
            slow = slow.next;
            n++;
        }

        int rotate = k % n;
        if (rotate == 0) {
            return head;
        }
        slow = head;
        for (int i = 1; i < n - rotate; i++) {
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        ListNode temp = newHead;
        for (int i = 1; i < rotate; i++) {
            temp = temp.next;
        }

        temp.next = head;

        return newHead;
    }
}
