package code.bloomberg;

import code.facebook.ListNode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
//Tc - O(M+N)
//SC - O(1)
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null){
            return null;
        }

        int l1 = getLength(headA);
        int l2 = getLength(headB);

        if(l1>l2){
            int diff = l1-l2;
            while(diff>0 && headA!=null){
                headA = headA.next;
                diff--;
            }
        }
        else if(l2>l1){
            int diff = l2-l1;
            while(diff>0 && headB!=null){
                headB = headB.next;
                diff--;
            }
        }

        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode head){
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
