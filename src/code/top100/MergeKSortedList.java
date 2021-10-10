package code.top100;

import java.util.List;

//https://www.youtube.com/watch?v=BBt9FB5Yt0M
public class MergeKSortedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(9);

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(7);
        l3.next.next = new ListNode(10);

        ListNode lists[] = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode list = mergeKLists(lists,0,lists.length-1);
        while(list!=null){
            System.out.print(list.val+" ");
            list = list.next;
        }
    }
    public static ListNode mergeKLists(ListNode lists[],int start,int end){

        if(start==end){
            return lists[end];
        }
        int mid = start+(end-start)/2;
        ListNode left = mergeKLists(lists,start,mid);
        ListNode right = mergeKLists(lists,mid+1,end);

        return merge(left,right);
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l1!=null && l2!=null){
            if(l1.val<l2.val){
                l1.next = merge(l1.next,l2);
                return l1;
            }
            else{
                l2.next = merge(l1,l2.next);
                return l2;
            }
        }

        return l1!=null?l1:l2;
    }
}
