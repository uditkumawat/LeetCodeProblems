package code.microsoft;

public class GetDecimalValueFromBinaryNumberInLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    static int res = 0;
    static int index = 0;
    public static void main(String args[]){

        GetDecimalValueFromBinaryNumberInLinkedList obj = new GetDecimalValueFromBinaryNumberInLinkedList();

        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next.next.next = new ListNode(1);

        System.out.println(obj.getDecimalValue(node));

    }

    //artihmetic
    public int getDecimalValue(ListNode head) {

        int res = head.val;
        ListNode curr = head;

        while(curr.next!=null){
            res = res*2 + curr.next.val;
            curr = curr.next;
        }

        return res;
    }

    public int getDecimal(ListNode head){
        int num = head.val;
        while(head.next!=null){
            num = (num<<1) | head.next.val;
            head = head.next;
        }
        return num;
    }
}
