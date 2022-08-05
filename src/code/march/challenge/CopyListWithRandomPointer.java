package code.march.challenge;

//https://leetcode.com/problems/copy-list-with-random-pointer
//TC - O(N)
//SC - O(1)
public class CopyListWithRandomPointer {

    static class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node5.random = node1;
        node4.random = node3;
        node3.random = node5;

        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        Node newHead = obj.copyRandomList(node1);
        while(newHead!=null){
            System.out.print(newHead.val+"->");
            newHead = newHead.next;
        }
    }

    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Node curr = head;

        //inserting cloned node in between two nodes
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //make links in random pointers of newly cloned node
        while(curr!=null && curr.next!=null){
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node oldHead = head;
        Node newHead = head.next;
        Node temp = newHead;
        while(oldHead!=null){
            oldHead.next = oldHead.next!=null ? oldHead.next.next : null;
            temp.next = temp.next!=null ? temp.next.next : null;
            oldHead = oldHead.next;
            temp = temp.next;
        }

        return newHead;
    }
}
