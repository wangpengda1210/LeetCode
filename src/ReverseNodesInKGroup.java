public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {
            current = reverseKGroup(current, k);
            for (int i = count; i > 0; i--) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }

        return head;
    }
}
