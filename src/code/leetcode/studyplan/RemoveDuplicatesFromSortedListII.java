package code.leetcode.studyplan;

import code.facebook.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
//TC - O(N)
//SC - O(1)
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return head;
        }

        ListNode senital = new ListNode(-1);

        senital.next = head;
        ListNode prev = senital;

        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                prev.next = head.next;
            }
            else{
                prev = prev.next;
            }
            head = head.next;
        }

        return senital.next;
    }
}
