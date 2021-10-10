package code.top100;

public class ReverseLinkedListSizeK {

    static class LinkedList{
        int val;
        LinkedList  next;
        LinkedList(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        LinkedList node = new LinkedList(1);
        node.next = new LinkedList(2);
        node.next.next = new LinkedList(3);
        node.next.next.next = new LinkedList(4);
        node.next.next.next.next = new LinkedList(5);
        node.next.next.next.next.next = new LinkedList(6);
        node.next.next.next.next.next.next = new LinkedList(7);
        int k = 8;

        LinkedList head = reverse(node,k);

        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static LinkedList reverse(LinkedList node,int k){
        if(node==null){
            return node;
        }
        LinkedList prev = null;
        LinkedList next = null;
        LinkedList curr = node;
        int c = 0;
        while(curr!=null && c<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }

        if(next!=null){
            node.next = reverse(next,k);
        }

        return prev;
    }
}
