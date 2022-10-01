package code.september2022.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
//TC - O(N)
//SC - O(1)
public class RemoveNthNodeFromEndOfLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n-->=0){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow!=null && slow.next!=null){
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
