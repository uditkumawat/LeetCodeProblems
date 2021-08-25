package code.top100;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static class Node{
        int val;
        Node next;
        Node random;
        Node(){}
        Node(int val){
            this.val = val;
            this.random = null;
            this.next = null;
        }
    }

    public Node copyRandomList(Node head) {

        if(head==null || head.next==null){
            return head;
        }

        Map<Node,Node> map = new HashMap<>();

        Node temp = head;

        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        while(temp!=null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
