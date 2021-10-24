public class MiddleOfLinkedList {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode end = head;
        ListNode middle = head;

        while (end.next != null) {
            end = end.next;
            if (end.next != null) {
                end = end.next;
            }
            middle = middle.next;
        }

        return middle;
    }
}
