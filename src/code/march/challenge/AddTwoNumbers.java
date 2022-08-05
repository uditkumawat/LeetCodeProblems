package code.march.challenge;

import code.facebook.ListNode;

//TC - O(max(m,n))
//https://leetcode.com/problems/add-two-numbers/solution/
//SC - O(max(m,n)+1)
public class AddTwoNumbers {

    public static void main(String args[]){

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode head = obj.addTwoNumbers(l1,l2);

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        int sum = 0;

        while(l1!=null || l2!=null){
            int a = l1!=null ? l1.val:0;
            int b = l2!=null ? l2.val:0;

            sum = a+b+carry;

            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(carry!=0){
            temp.next = new ListNode(carry);
        }

        return head.next;
    }
}
