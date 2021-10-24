public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        return reverseNext(head, count);
    }

    public ListNode reverseNext(ListNode head, int count) {
        if (count <= 0) {
            return null;
        }

        ListNode curr = head;
        for (int i = 0; i < count - 1; i++) {
            curr = curr.next;
        }
        curr.next = reverseNext(head, count - 1);
        return curr;
    }
}
