package code.explorecard.recursion;

import code.facebook.ListNode;

public class ReverseLinkedList {

    public static void main(String args[]){

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        ReverseLinkedList obj = new ReverseLinkedList();
        obj.printList(list);
        list = obj.reverseListUtil(list,null);
        System.out.println("\nAfter reversing");
        obj.printList(list);
    }

    public void printList(ListNode list){
        ListNode temp = list;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
    public ListNode reverseList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode next = null;
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

    public ListNode reverseListUtil(ListNode head,ListNode prev) {

        if(head==null){
            return prev;
        }

        ListNode next = head.next;
        head.next = prev;
        prev = head;

        return reverseListUtil(next,prev);
    }
}
