package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/add-two-numbers/submissions/
//TC - O(max(m,n))
//SC - O(Max(m,n))+1
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null && l2==null){
            return null;
        }

        if(l1==null && l2!=null){
            return l2;
        }

        if(l1!=null && l2==null){
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int sum = 0;
        int carry = 0;

        while(l1!=null || l2!=null || carry!=0){
            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;

            sum = x+y+carry;
            carry = sum/10;

            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;
            temp = newNode;

            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }

        return dummy.next;
    }
}
