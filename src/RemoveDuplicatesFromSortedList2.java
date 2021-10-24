public class RemoveDuplicatesFromSortedList2 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode start = new ListNode();
        start.next = head;

        ListNode valid = start;
        ListNode current = start.next;
        int currentVal = current.val;
        int currentCount = 1;

        while (current.next != null) {
            if (current.next.val == currentVal) {
                currentCount++;
            } else {
                if (currentCount == 1) {
                    valid.next = current;
                    valid = valid.next;
                } else {
                    valid.next = current.next;
                }
                currentVal = current.next.val;
                currentCount = 1;
            }
            current = current.next;
        }

        if (currentCount != 1) {
            valid.next = null;
        }

        return start.next;
    }
}
