public class MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode currentNode = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        if (l1 == null) {
            currentNode.next = l2;
        } else {
            currentNode.next = l1;
        }

        return mergedList.next;
    }
}
