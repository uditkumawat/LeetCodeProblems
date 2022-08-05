package code.bloomberg;

import code.facebook.ListNode;

import java.util.Stack;

//https://leetcode.com/problems/add-two-numbers-ii/solution/
//TC - O(m+n)
//Sc - O(Math.max(m,n))
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);

        ListNode head = null;
        int carry = 0;

        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){

            int sum = carry;

            if(!s1.isEmpty()){
                sum = sum + s1.pop();
            }

            if(!s2.isEmpty()){
                sum = sum + s2.pop();
            }

            ListNode newNode = new ListNode(sum%10);
            newNode.next = head;
            head = newNode;

            carry = sum/10;
        }

        return head;
    }

    public Stack<Integer> getStack(ListNode head){
        Stack<Integer> st = new Stack();
        ListNode node = head;
        while(node!=null){
            st.push(node.val);
            node = node.next;
        }
        return st;
    }
}
