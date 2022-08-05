package code.march.challenge;

import code.facebook.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/
//TC- O(m+n)
//SC - O(1)
public class MergeTwoSortedLists {

    public static void main(String args[]){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        ListNode list = obj.mergeTwoLists(list1,list2);

        while(list!=null){
            System.out.print(list.val+" ");
            list = list.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null && list2==null){
            return null;
        }

        if(list1==null){
            return list2;
        }


        if(list2==null){
            return list1;
        }

        ListNode dummy = new ListNode(-101);
        ListNode temp = dummy;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1!=null){
            temp.next = list1;
        }


        if(list2!=null){
            temp.next = list2;
        }

        return dummy.next;
    }
}
