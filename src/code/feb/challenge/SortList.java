package code.feb.challenge;

public class SortList {

    public static void main(String args[]){

        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        SortList obj = new SortList();

        obj.printList(head);

        System.out.println("\nAfter sorting");

        head = obj.sortList(head);

        obj.printList(head);

    }

    public void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;

        while(first!=null && first.next!=null){
            prev = second;
            first = first.next.next;
            second = second.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(second);

        return mergeList(l1,l2);
    }

    public ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next = mergeList(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeList(l1,l2.next);
            return l2;
        }
    }
}
