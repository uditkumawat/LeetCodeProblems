package code.blind75;

import code.facebook.ListNode;

//https://leetcode.com/problems/reorder-list/submissions/
//TC - O(N)
public class ReorderList {

    public void reorderList(ListNode head) {

        if(head==null || head.next==null){
            return;
        }

        ListNode first = head;
        ListNode second = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // prev.next = null;

        second = reverse(slow);

        while(second.next!=null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;

        }

    }

    public ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode next = head;
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
