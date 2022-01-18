import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        ListNode head = new ListNode();
        ListNode curr = head;

        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            if (listNode != null) {
                minHeap.add(new int[] { listNode.val, i });
                lists[i] = listNode.next;
            }
        }

        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            int listIndex = min[1];

            curr.next = new ListNode(min[0]);
            curr = curr.next;

            if (lists[listIndex] != null) {
                ListNode listNode = lists[listIndex];
                minHeap.add(new int[] { listNode.val, listIndex });
                lists[listIndex] = listNode.next;
            }
        }

        return head.next;
    }
}
