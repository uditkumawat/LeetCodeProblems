package code.bloomberg;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=rbXeQ0E7v70
public class FlattenMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        if(head==null){
            return head;
        }

        Node temp = head;

        while(temp!=null){

            if(temp.child!=null){

                Node next = temp.next;

                temp.next = flatten(temp.child);
                temp.next.prev = temp;
                temp.child = null;

                while(temp.next!=null){
                    temp = temp.next;
                }

                if(next!=null){
                    temp.next = next;
                    temp.next.prev = temp;
                }
            }

            temp = temp.next;
        }

        return head;
    }
}
