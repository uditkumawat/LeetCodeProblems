package code.march.challenge;

import code.facebook.ListNode;

public class RemoveDuplicatesFromSortedList {


    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
     //   head.next.next.next = new ListNode(3);
      //  head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();

        head = obj.deleteDuplicates(head);

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy = new ListNode(-101);

        ListNode temp = dummy;
        ListNode curr = head;

        while(curr!=null){
            if(curr.val!=temp.val){
                temp.next = curr;
                temp = curr;
            }
            curr = curr.next;
        }

        temp.next = null;

        return dummy.next;
    }
}
