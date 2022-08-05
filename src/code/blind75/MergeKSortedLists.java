package code.blind75;

import code.facebook.ListNode;

/**
 * Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
 *
 * We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
 * Sum up the merge process and we can get: O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log k)O(∑
 * i=1
 * log
 * 2
 * ​
 *  k
 * ​
 *  N)=O(Nlogk)
 * Space complexity : O(1)O(1)
 *
 * We can merge two sorted linked lists in O(1)O(1) space.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode lists[], int start, int end){
        if(start==end){
            return lists[start];
        }

        int mid = start+(end-start)/2;

        ListNode first = mergeKLists(lists,start,mid);
        ListNode second = mergeKLists(lists,mid+1,end);

        return merge(first,second);
    }

    public ListNode merge(ListNode first,ListNode second){
        if(first==null){
            return second;
        }
        if(second==null){
            return first;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode newHead = prev;

        while(first!=null && second!=null){
            if(first.val<second.val){
                prev.next = first;
                first = first.next;
            }
            else{
                prev.next = second;
                second = second.next;
            }
            prev = prev.next;
        }

        prev.next = first!=null?first:second;

        return newHead.next;

    }
}
