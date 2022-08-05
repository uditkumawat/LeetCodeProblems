package code.march.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/rotate-list/
//TC- O(N)
public class RotateList {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateList obj = new RotateList();

        head = obj.rotateRight(head,4);

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }

    }
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0){
            return head;
        }

        ListNode curr = head;
        int len = 0;
        while(curr.next!=null){
            curr = curr.next;
            len++;
        }

        curr.next = head;

        k = k % len;

        curr = head;

        for(int i=0;i<=len-k;i++){
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;

    }
}
