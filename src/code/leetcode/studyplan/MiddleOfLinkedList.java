package code.leetcode.studyplan;

import code.facebook.ListNode;

//https://leetcode.com/problems/middle-of-the-linked-list/solution/
//TC - O(N)
//SC - O(1)
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
