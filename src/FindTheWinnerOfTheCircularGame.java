import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int findTheWinner(int n, int k) {
        ListNode head = new ListNode(1);
        ListNode curr = head;

        for (int i = 2; i <= n; i++) {
            curr.next = new ListNode(i);
            curr.next.prev = curr;
            curr = curr.next;
        }
        curr.next = head;
        head.prev = curr;

        curr = head;
        while (curr.val != curr.next.val) {
            for (int i = 0; i < k - 1; i++) {
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr = curr.next;
        }

        return curr.val;
    }
}
