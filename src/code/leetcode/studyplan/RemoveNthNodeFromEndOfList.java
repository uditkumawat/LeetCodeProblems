package code.leetcode.studyplan;

import code.facebook.ListNode;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
//TC - O(N)
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode prev = null;

        int count = 0;
        while(fast!=null){

            count++;
            fast = fast.next;
            if(count>n){
                prev = slow;
                slow = slow.next;
            }
        }


        if(prev!=null && prev.next!=null){
            prev.next = prev.next.next;
        }

        return dummy.next;
    }
}
