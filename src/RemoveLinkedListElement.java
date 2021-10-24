public class RemoveLinkedListElement {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode currentNode = newHead;

        while (currentNode != null) {
            while (currentNode.next != null && currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }

        return newHead.next;
    }
}
