package code.google;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointer {

    public static void main(String args[]){

        Node head = new Node(1);

    }
    public Node copyRandomList(Node head) {

        if(head==null){
            return head;
        }

        Node temp = head;

        //adding newNode inbetween two nodes

        while(temp!=null){
            Node newNode = new Node(temp.val);
            Node temp_next = temp.next;
            temp.next = newNode;
            newNode.next = temp_next;
            temp = temp_next;
        }

        //updating random pointers

        temp = head;
        while(temp!=null){
            if(temp.next!=null && temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next;
        }

        Node newHead = head.next;
        Node copy = newHead;
        Node orig = head;
        while(orig!=null && orig.next!=null){
            orig.next = orig.next.next;
            copy.next = copy.next.next;
            orig = orig.next;
            copy = copy.next;
        }

        return newHead;
    }
}
