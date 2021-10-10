package code.top100;

//https://www.youtube.com/watch?v=5PLdnPfkO6w&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=3
public class ReverseLinkedListUsingRecursion {
    
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    
    static ListNode head = null;

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

        recur(null,root);
        temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
    
    public static void recur(ListNode prev,ListNode curr){
        if(curr==null){
            return;
        }
        if(curr.next==null){
            head = curr;
            curr.next = prev;
            return;
        }
        recur(curr,curr.next);
        curr.next = prev;
    }
}
