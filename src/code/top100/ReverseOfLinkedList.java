package code.top100;

//TC - O(n)
public class ReverseOfLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode temp = root;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

        System.out.println("\nAfter reversal");

        temp = reverseList(root);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
