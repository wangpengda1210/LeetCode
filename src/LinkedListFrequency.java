import java.util.HashMap;
import java.util.Map;

public class LinkedListFrequency {
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

    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, Integer> count = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            count.put(curr.val, count.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode freqHead = new ListNode();
        curr = freqHead;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            curr.next = new ListNode(entry.getValue());
            curr = curr.next;
        }

        return freqHead.next;
    }
}
