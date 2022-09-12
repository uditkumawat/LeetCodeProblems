package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
//TC - O(N)
//SC - O(N) - stack recursion
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode nextNext = head.next.next;
        ListNode next = head.next;
        next.next = head;

        head.next = swapPairs(nextNext);

        return next;
    }
}
