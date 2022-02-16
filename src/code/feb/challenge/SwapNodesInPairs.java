package code.feb.challenge;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapNodesInPairs obj = new SwapNodesInPairs();

        head = obj.swapPairs(head);

        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        //swapping
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
