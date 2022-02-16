package code.design;

import java.util.HashMap;
import java.util.Map;

//TC - O(1)

public class LRUCache {

    class DLLNode{
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
        DLLNode(){

        }
        DLLNode(int key,int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    DLLNode head;
    DLLNode tail;
    int capacity;
    Map<Integer,DLLNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLLNode();
        this.tail = new DLLNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            DLLNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            removeNode(node);
            node.value = value;
            addNode(node);
            map.put(key,node);
        }
        else{
            if(this.capacity==this.map.size()){
                map.remove(this.tail.prev.key);
                removeNode(this.tail.prev);
            }
            DLLNode node = new DLLNode(key,value);
            addNode(node);
            map.put(key,node);
        }
    }

    public void removeNode(DLLNode node){
        if(node!=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNode(DLLNode node){
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    public static void main(String args[]){
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
