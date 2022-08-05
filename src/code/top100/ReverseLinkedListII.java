package code.top100;

import code.facebook.ListNode;

//https://www.youtube.com/watch?v=svLDeQKp8dY&list=PLEI-q7w3s9gTvgOOiI_Dx5odhcOx1N2AW&index=25
public class ReverseLinkedListII {

    public static void main(String args[]){

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ReverseLinkedListII obj = new ReverseLinkedListII();

        System.out.println("Initial list");
        obj.printList(list);

        obj.reverse(list,left,right);

        System.out.println("After reversing");
        obj.printList(list);
    }

    public void printList(ListNode list){
        ListNode temp = list;
        while(temp!=null){
            System.out.println(temp.val+" ");
            temp = temp.next;
        }
    }

    public void reverse(ListNode list,int left,int right){

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = list;

        int k = 1;
        while(k<left){
            prev = curr;
            curr = curr.next;
            k++;
        }

        k = right-left;

        while(k>=0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
    }
}
