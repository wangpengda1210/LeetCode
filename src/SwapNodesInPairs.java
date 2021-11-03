import java.util.Objects;

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode current = head;

        if (head != null && head.next != null) {
            head = head.next;
        }

        while (current != null) {
            ListNode next = current.next;
            ListNode temp = null;

            if (next != null) {
                temp = next.next;
                if (next.next != null) {
                    if (next.next.next != null) {
                        current.next = next.next.next;
                    } else {
                        current.next = next.next;
                    }
                } else {
                    current.next = null;
                }

                next.next = current;
            }

            current = temp;
        }

        return head;
    }
}
