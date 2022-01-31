package code.facebook;

/**
 * Time complexity: \mathcal{O}(N)O(N). There are three steps here. To identify the middle node takes \mathcal{O}(N)O(N) time. To reverse the second part of the list, one needs N/2N/2 operations. The final step, to merge two lists, requires N/2N/2 operations as well. In total, that results in \mathcal{O}(N)O(N) time complexity.
 *
 * Space complexity: \mathcal{O}(1)O(1), since we do not allocate any additional data structures.
 */
public class ReorderList {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList obj = new ReorderList();

        obj.reorderList(head);

        obj.printList(head);
    }

    public void printList(ListNode head){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        //find middle node
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second list
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = slow;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        //merge two lists
        ListNode first = head;
        ListNode second = prev;
        ListNode temp = null;

        while(second.next!=null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        printList(head);

        return;
    }
}
