public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode();
        ListNode moreHead = new ListNode();

        ListNode lessCurr = lessHead;
        ListNode moreCurr = moreHead;

        while (head != null) {
            if (head.val < x) {
                lessCurr.next = head;
                lessCurr = lessCurr.next;
            } else {
                moreCurr.next = head;
                moreCurr = moreCurr.next;
            }

            head = head.next;
        }

        lessCurr.next = moreHead.next;
        moreCurr.next = null;

        return lessHead.next;
    }
}
