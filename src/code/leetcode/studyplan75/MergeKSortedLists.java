package code.leetcode.studyplan75;

import code.facebook.ListNode;

//https://leetcode.com/problems/merge-k-sorted-lists/submissions/
//TC - O(nlogk)
//SC - O(1) // merging is iterative
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0){
            return null;
        }

        return mergeLists(lists,0,lists.length-1);
    }

    public ListNode mergeLists(ListNode lists[],int start,int end){
        if(start==end){
            return lists[start];
        }

        int mid = start+(end-start)/2;

        ListNode first = mergeLists(lists,start,mid);
        ListNode second = mergeLists(lists,mid+1,end);

        return merge(first,second);
    }

    public ListNode merge(ListNode l1,ListNode l2){

        if(l1==null && l2==null){
            return null;
        }

        if(l1!=null && l2==null){
            return l1;
        }

        if(l1==null && l2!=null){
            return l2;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(l1!=null && l2!=null){

            if(l1.val<l2.val){
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        while(l1!=null){
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }


        while(l2!=null){
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
