package code.top100;

public class MergeTwoLists {

    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeTwoLists(l1,l2);

        while(mergedList!=null){
            System.out.print(mergedList.val+" ");
            mergedList = mergedList.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        ListNode head = new ListNode();

        ListNode tail = head;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1==null)?l2:l1;

        return head.next;
    }
}
