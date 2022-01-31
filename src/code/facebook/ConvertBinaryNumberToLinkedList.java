package code.facebook;

public class ConvertBinaryNumberToLinkedList {

    public static void main(String args[]){
        ListNode list = new ListNode(1);
        list.next = new ListNode(0);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(1);
        list.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next = new ListNode(1);
        list.next.next.next.next.next.next.next = new ListNode(1);
        list.next.next.next.next.next.next.next.next = new ListNode(1);
        list.next.next.next.next.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        list.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);


        ConvertBinaryNumberToLinkedList obj = new ConvertBinaryNumberToLinkedList();

        System.out.println(obj.getDecimalValue(list));

    }
    public int getDecimalValue(ListNode head) {

        if(head==null){
            return 0;
        }

        int num = 0;
        ListNode temp = head;
        while(temp!=null){

            int val = temp.val;
            num<<=1;
            if(val==1){
                num = num | 1;
            }
            temp = temp.next;
        }

        return num;
    }
}
