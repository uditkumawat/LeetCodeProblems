package code.google;

import code.facebook.ListNode;

//https://www.youtube.com/watch?v=Lhu3MsXZy-Q
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();

        head = obj.removeNthFromEnd(head,2);

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(-1);
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
