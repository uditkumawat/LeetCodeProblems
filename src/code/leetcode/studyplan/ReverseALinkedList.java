package code.leetcode.studyplan;

import code.facebook.ListNode;

//https://leetcode.com/problems/reverse-linked-list/submissions/
//TC - O(N)
//SC - O(!)
public class ReverseALinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
