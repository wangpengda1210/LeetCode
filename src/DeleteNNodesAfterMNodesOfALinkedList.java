public class DeleteNNodesAfterMNodesOfALinkedList {
    public static class ListNode {
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

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            int count = 0;
            while (count < m && curr != null) {
                prev = curr;
                curr = curr.next;
                count++;
            }

            count = 0;
            while (count < n && curr != null) {
                curr = curr.next;
                count++;
            }

            prev.next = curr;
        }

        return head;
    }
}
