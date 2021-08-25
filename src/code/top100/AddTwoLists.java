package code.top100;

public class AddTwoLists {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode list = addTwoNumbers(l1,l2);
        while(list!=null){
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        int carry = 0;
        int sum = 0;

        ListNode head = new ListNode();
        ListNode prev = new ListNode();;

        head = prev;

        while(l1!=null || l2!=null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;

            sum = x+y+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            prev.next = node;
            prev = node;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(carry>0){
            prev.next = new ListNode(carry);
        }

        return head.next;
    }
}
