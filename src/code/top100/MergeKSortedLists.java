package code.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//TC-)(nlogn)
public class MergeKSortedLists {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        ListNode finalList = mergeKLists(lists);

        while(finalList!=null){
            System.out.println(finalList.val);
            finalList = finalList.next;
        }
    }

    public static ListNode mergeKLists(List<ListNode> lists) {

        if(lists==null || lists.size()==0){
            return null;
        }

        ListNode tail = new ListNode();
        ListNode head = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(),(ListNode a, ListNode b)->{
            return a.val-b.val;
        });

        for(ListNode listHead:lists){
            if(listHead!=null)
                pq.add(listHead);
        }

        while(!pq.isEmpty()){
            ListNode extractedNode = pq.poll();
            ListNode newNode = new ListNode(extractedNode.val);
            tail.next = newNode;
            tail = newNode;

            if(head==null){
                head = newNode;
            }

            if(extractedNode.next!=null){
                pq.add(extractedNode.next);
            }
        }

        return head;
    }
}
