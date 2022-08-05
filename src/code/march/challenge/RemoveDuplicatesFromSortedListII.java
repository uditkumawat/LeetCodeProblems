package code.march.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
//TC - O(N)
//SC - O(1)
public class RemoveDuplicatesFromSortedListII {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
     //   head.next.next.next.next.next = new ListNode(4);
      //  head.next.next.next.next.next.next = new ListNode(5);

        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();

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

        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }
            else{
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
