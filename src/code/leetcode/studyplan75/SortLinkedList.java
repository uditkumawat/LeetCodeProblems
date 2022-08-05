package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/sort-list/submissions/
//TC - O(nlogn)
public class SortLinkedList {

    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(slow);

        return mergeLists(first,second);
    }

    public ListNode mergeLists(ListNode first,ListNode second){
        if(first==null && second==null){
            return null;
        }
        if(first!=null && second==null){
            return first;
        }
        if(first==null && second!=null){
            return second;
        }

        if(first.val<second.val){
            first.next = mergeLists(first.next,second);
            return first;
        }
        else{
            second.next = mergeLists(first,second.next);
            return second;
        }

    }
}
