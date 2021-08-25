package code.top100;

public class IntersectionOfLists {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = lengthOfList(headA);
        int lenB = lengthOfList(headB);

        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenA<lenB){
            headB = headB.next;
            lenB--;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;

    }



    public int lengthOfList(ListNode head){
        if(head==null){
            return 0;
        }

        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
