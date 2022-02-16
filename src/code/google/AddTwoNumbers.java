package code.google;

import code.facebook.ListNode;

//https://leetcode.com/problems/add-two-numbers/
//TC - O(max(mn,n))
public class AddTwoNumbers {

    public static void main(String args[]){

        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next.next = new ListNode(9);

        ListNode list2 = new ListNode(9);
        list2.next = new ListNode(9);
        list2.next.next = new ListNode(9);
        list2.next.next.next = new ListNode(9);

        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode res = obj.addTwoNumbers(list1,list2);

        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }

    }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }

        if(list2==null){
            return list1;
        }

        int sum = 0;
        int carry = 0;
        int first = 0;
        int second = 0;

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while(list1!=null || list2!=null){
            first = list1!=null ? list1.val:0;
            second = list2!=null ? list2.val:0;

            sum = first+second+carry;
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            res.next = node;
            res = node;

            if(list1!=null){
                list1 = list1.next;
            }

            if(list2!=null){
                list2 = list2.next;
            }
        }

        if(carry==1){
            res.next = new ListNode(1);
        }

        return head.next;
    }
}
