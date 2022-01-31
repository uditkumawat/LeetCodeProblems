package code.facebook;

public class InsertionSortList {

    public static void main(String args[]){

        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);

        InsertionSortList obj = new InsertionSortList();
        root = obj.insertionSortList(root);
        obj.printList(root);

    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        return getSortedList(head);
    }

    public ListNode getSortedList(ListNode head){

        ListNode dummy = new ListNode(-1);
        ListNode curr = head;

        while(curr!=null){

            ListNode prev = dummy;

            while(prev.next!=null && prev.next.val<curr.val){
                prev = prev.next;
            }

            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}
