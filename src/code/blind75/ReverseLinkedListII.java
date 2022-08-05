package code.blind75;

import code.facebook.ListNode;

//https://leetcode.com/problems/reverse-linked-list-ii/submissions/
//TC - O(N)
//SC - O(1)
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null){
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(left>1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode con = prev;
        ListNode tail = curr;

        ListNode next = null;
        while(right>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }

        //adjusting the head of reversed list
        if(con!=null){
            con.next = prev;
        }
        else{
            head = prev;
        }

        tail.next = curr;

        return head;

    }
}
