package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/rotate-list/submissions/
//TC - O(N)
//SC - O(1)
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return null;
        }

        int size = 1;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        k = k%size;

        for(int i=0;i<size-k-1;i++){
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
