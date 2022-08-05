package code.april.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/solution/
//TC - O(N) - one pass
//SC - O(1)
public class SwappingNodesInALinkedList {

    public static void main(String args[]){

        ListNode head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Before swapping");

        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

        SwappingNodesInALinkedList obj = new SwappingNodesInALinkedList();

        head = obj.swapNodes(head,4);

        System.out.println("\nAfter swapping");
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }

    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return head;
        }

        ListNode kthNodeFromBegin = head;
        ListNode kthNodeFromEnd = head;
        ListNode fast = head;
        ListNode slow = head;

        for(int i=0;i<k-1;i++){
            kthNodeFromBegin = kthNodeFromBegin.next;
            fast = fast.next;
        }

        fast = fast.next;

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        kthNodeFromEnd = slow;

        int temp = kthNodeFromBegin.val;
        kthNodeFromBegin.val = kthNodeFromEnd.val;
        kthNodeFromEnd.val = temp;


        return head;

    }
}
