package code.top100;


//TC - O(N)
//SC - O(1)
public class FlattenDoubleLinkedList {

    static class DLLNode{
        int val;
        DLLNode prev;
        DLLNode next;
        DLLNode child;
        DLLNode(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }

    public static void main(String args[]){

        DLLNode n1 = new DLLNode(1);
        DLLNode n2 = new DLLNode(2);
        DLLNode n3 = new DLLNode(3);
        DLLNode n4 = new DLLNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n2.prev = n1;
        n3.prev = n2;
        n4.prev = n3;

        DLLNode n5 = new DLLNode(5);
        DLLNode n6 = new DLLNode(6);
        DLLNode n7 = new DLLNode(7);

        n5.next = n6;
        n6.next = n7;

        n6.prev = n5;
        n7.prev = n6;

        n4.child = n5;

        DLLNode finalList = flatten(n1);

        while(finalList!=null){
            System.out.println(finalList.val);
            finalList = finalList.next;
        }
    }

    public static DLLNode flatten(DLLNode head){
        if(head==null)
            return head;

        DLLNode curr = head;
        while(curr!=null){

            //if no child, so only move ahead
            if(curr.child==null){
                curr = curr.next;
                continue;
            }

            //if child found, then find the tail and link to curr.next;
            DLLNode child = curr.child;
            while(child.next!=null){
                child = child.next;
            }
            child.next = curr.next;
            //as it is DLL, so link the prev of next node also if present
            if(curr.next!=null)
                curr.next.prev = child;

            //link curr next to next pointer i.e. child node
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }

        return head;
    }
}
