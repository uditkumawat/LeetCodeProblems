package code.bloomberg;

import code.facebook.ListNode;

//https://leetcode.com/problems/add-two-numbers/solution/
//TC - O(max(len l1,len l2))
//SC - O(max(len l1,len l2))+1 , if carry is there then +1
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        int carry = 0;
        int sum = 0;

        while(l1!=null || l2!=null){

            int first = l1!=null ? l1.val : 0;
            int second = l2!=null ? l2.val : 0;

            sum = first+second+carry;

            carry = sum/10;

            ListNode node = new ListNode(sum % 10);
            res.next = node;
            res = res.next;

            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }

        if(carry>0){
            ListNode node = new ListNode(carry);
            res.next = node;
        }

        return dummy.next;
    }
}
