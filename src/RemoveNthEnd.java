public class RemoveNthEnd {
    public MiddleOfLinkedList.ListNode removeNthFromEnd(MiddleOfLinkedList.ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        MiddleOfLinkedList.ListNode end = head;
        MiddleOfLinkedList.ListNode middle = head;

        for (int i = 1; i <= n; i++) {
            end = end.next;
        }

        if (end == null) {
            return head.next;
        }

        while (true) {
            end = end.next;

            if (end == null) {
                break;
            }

            middle = middle.next;
        }

        middle.next = middle.next.next;
        return head;
    }
}
