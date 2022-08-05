package code.bloomberg;

import code.facebook.ListNode;

//https://leetcode.com/problems/reverse-linked-list/solution/
//TC - O(N)
//SC - O(1)
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {

        return reverse(head,null);
    }

    public ListNode reverse(ListNode head,ListNode prev){
        if(head==null){
            return prev;
        }

        ListNode next = head.next;
        head.next = prev;

        return reverse(next,head);
    }
}
