package code.booking.com;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//TC- O(N)
//SC - O(1)
public class RemoveKthNodeFromLinkedList {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        int k = 2;

        RemoveKthNodeFromLinkedList obj = new RemoveKthNodeFromLinkedList();

        head = obj.removeNthFromEnd(head,k);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return head;
        }

        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int j=0;j<=n;j++){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow!=null && slow.next!=null){
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
