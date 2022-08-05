package code.march.challenge;

import code.facebook.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedList {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // Key: val  Value: its frequency
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        curr = dummy;
        while (head != null) {
            if (map.get(head.val) == 1) {
                curr.next = head;
                curr = curr.next;
            }

            head = head.next;
        }

        curr.next = null;
        return dummy.next;
    }
}
