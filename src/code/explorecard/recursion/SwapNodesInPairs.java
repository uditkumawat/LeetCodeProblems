package code.explorecard.recursion;

import code.facebook.ListNode;

//https://leetcode.com/problems/swap-nodes-in-pairs/solution/
//TC - O(N)
//SC - O(N)
public class SwapNodesInPairs {

    public static void main(String args[]){

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);


        SwapNodesInPairs obj = new SwapNodesInPairs();
        obj.printList(list);
        list = obj.swapPairs(list);
        System.out.println();
        obj.printList(list);

    }

    public void printList(ListNode list){
        ListNode temp = list;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
