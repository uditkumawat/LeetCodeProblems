package code.leetcodeTopInterviewQuestions;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
//TC - O(L) - length of list
//SC - O(1)
public class RemoveNthNodesFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
