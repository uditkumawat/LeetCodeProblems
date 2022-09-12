package code.august2022.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/palindrome-linked-list/submissions/
//TC - O(N)
//SC - O(1)
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode list1 = head;
        ListNode list2 = reverse(slow);

        while(list1!=null && list2!=null){
            if(list1.val!=list2.val){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){

        if(head==null){
            return null;
        }

        ListNode prev = null;
        ListNode next = head;
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
