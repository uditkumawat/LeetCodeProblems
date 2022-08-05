package code.july.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/partition-list/
//TC- O(N)
//SC - O(1)
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }

        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;

        ListNode curr = head;
        while(curr!=null){
            if(curr.val<x){
                before.next = curr;
                before = before.next;
            }
            else{
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
