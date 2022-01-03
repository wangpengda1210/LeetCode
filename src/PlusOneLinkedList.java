public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode temp = new ListNode(0, head);

        ListNode p = temp;
        ListNode start = temp;
        while (p != null) {
            if (p.val != 9) {
                start = p;
            }
            p = p.next;
        }

        start.val += 1;
        while (start.next != null) {
            start = start.next;
            start.val = 0;
        }

        return temp.val == 0 ? temp.next : temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
