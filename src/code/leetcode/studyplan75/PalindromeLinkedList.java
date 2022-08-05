package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(next!=null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    public boolean isPalindrome(ListNode head) {

        if(head==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        ListNode secondHead = null;

        //fast will not be equal to null, if odd elements
        if(fast!=null){
            secondHead = slow.next;
        }
        else{
            secondHead = slow;
        }

        //reverse second half
        secondHead = reverse(secondHead);

        while(head!=null && secondHead!=null){

            if(head.val!=secondHead.val){
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
    }
}
