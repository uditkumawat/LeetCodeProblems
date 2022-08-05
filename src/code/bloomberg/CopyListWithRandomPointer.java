package code.bloomberg;

//https://leetcode.com/problems/copy-list-with-random-pointer/solution/
//TC - O(N)
//SC - O(1)
public class CopyListWithRandomPointer {

    class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Node curr = head;

        //adding new node in between
        while(curr!=null){

            Node newNode = new Node(curr.val);

            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;

            curr = newNode.next;
        }

        curr = head;

        //setting random node

        while(curr!=null){

            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            else{
                curr.next.random = null;
            }

            curr = curr.next.next;
        }

        //removing newlist from in between

        Node ptrOldList = head;
        Node ptrNewList = head.next;
        Node headNew = head.next;

        while(ptrOldList!=null){
            ptrOldList.next = ptrOldList.next!=null?ptrOldList.next.next:null;
            ptrNewList.next = ptrNewList.next!=null?ptrNewList.next.next:null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }

        return headNew;
    }
}
