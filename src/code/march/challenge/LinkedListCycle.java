package code.march.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
//TC - O(N)
public class LinkedListCycle {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = node;

        LinkedListCycle obj = new LinkedListCycle();

        System.out.println(obj.hasCycle(head));

    }

    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

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
