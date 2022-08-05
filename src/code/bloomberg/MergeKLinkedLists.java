package code.bloomberg;

import code.facebook.ListNode;

//https://leetcode.com/problems/merge-k-sorted-lists/
//TC - O(nlogk)
//SC - O(k)
public class MergeKLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int start,int end){

        if(start==end){
            return lists[start];
        }

        int mid = start+(end-start)/2;

        ListNode first = mergeKLists(lists,start,mid);
        ListNode second = mergeKLists(lists,mid+1,end);

        return merge(first,second);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null && l2==null){
            return null;
        }

        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
