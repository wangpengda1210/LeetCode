public class ReverseLinkedListII {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        newHead.next = head;

        int currPos = 0;
        ListNode reversePrev = newHead;
        while (currPos < left - 1) {
            reversePrev = reversePrev.next;
            currPos++;
        }

        ListNode reverseLast = reversePrev.next;
        ListNode curr = reverseLast;
        ListNode prev = null;
        currPos++;

        while (currPos <= right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            currPos++;
        }

        reversePrev.next = prev;
        reverseLast.next = curr;

        return newHead.next;
    }
}
