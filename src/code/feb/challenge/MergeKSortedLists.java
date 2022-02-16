package code.feb.challenge;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String args[]){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        MergeKSortedLists obj = new MergeKSortedLists();

        ListNode l = obj.mergeKLists(lists);

        while(l!=null){
            System.out.println(l.val);
            l = l.next;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((ListNode a, ListNode b)->{
            return a.val-b.val;
        });

        for(int i=0;i<lists.length;i++){
            pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next!=null){
                pq.add(node.next);
            }
            temp.next = node;
            temp = node;
        }

        return head.next;
    }
}
