package code.blind75;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
//TC - O(N)
//SC - O(1)
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ListNode start = new ListNode(-1);
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;

        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
