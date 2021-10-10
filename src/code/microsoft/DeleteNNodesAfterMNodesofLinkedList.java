package code.microsoft;

/**
 * Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
 *
 * Start with the head as the current node.
 * Keep the first m nodes starting with the current node.
 * Remove the next n nodes
 * Keep repeating steps 2 and 3 until you reach the end of the list.
 * Return the head of the modified list after removing the mentioned nodes.
 */
public class DeleteNNodesAfterMNodesofLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        DeleteNNodesAfterMNodesofLinkedList obj = new DeleteNNodesAfterMNodesofLinkedList();

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);
        root.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        root.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        root.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        int m = 2;
        int n = 3;
        ListNode head = obj.deleteNodes(root,m,n);

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode curr = head;

        while(curr!=null){

            int mm = m;
            ListNode prev = null;
            while(curr!=null && mm-->0){
                prev = curr;
                curr = curr.next;
            }

            int nn = n;
            ListNode toRemove = curr;
            while(toRemove!=null && nn-->0){
                toRemove = toRemove.next;
            }

            if(prev!=null) {
                prev.next = toRemove;
            }
            curr = toRemove;
        }

        return head;
    }
}
