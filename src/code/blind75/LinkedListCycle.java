package code.blind75;

import code.facebook.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
//TC - O(N)

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }
}
