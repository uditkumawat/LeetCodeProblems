package code.leetcode.studyplan;

import code.facebook.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/
//TC - O(m+n)
//SC - O(m+n)
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }

        if(list1==null && list2!=null){
            return list2;
        }

        if(list1!=null && list2==null){
            return list1;
        }

        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }

    }
}
