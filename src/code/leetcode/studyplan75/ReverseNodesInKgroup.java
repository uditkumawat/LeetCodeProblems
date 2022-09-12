package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
//TC - O(N)
//SC - O(N/K)
public class ReverseNodesInKgroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null){
            return head;
        }

        int size = 0;
        ListNode temp = head;

        while(temp!=null){
            size++;
            temp = temp.next;
        }

        return reverse(head,size,k);
    }

    public ListNode reverse(ListNode head,int size,int k){

        if(head==null || size<k){
            return head;
        }

        int count = 0;

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(count<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next!=null){
            head.next = reverse(next,size-k, k);
        }

        return prev;
    }
}
