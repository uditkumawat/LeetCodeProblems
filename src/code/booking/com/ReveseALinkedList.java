package code.booking.com;

import code.facebook.ListNode;

public class ReveseALinkedList {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReveseALinkedList obj = new ReveseALinkedList();

        head = obj.reverseList(head,null);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode reverseList(ListNode curr,ListNode prev){
        if(curr==null){
            return prev;
        }

        ListNode temp = reverseList(curr.next,curr);
        curr.next = prev;
        return temp;
    }
}
