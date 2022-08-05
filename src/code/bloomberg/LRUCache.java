package code.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLLNode{
        int key;
        int value;
        DLLNode next;
        DLLNode prev;
        DLLNode(){}
        DLLNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    DLLNode head;
    DLLNode tail;
    Map<Integer,DLLNode> map;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap();
        this.head = new DLLNode();
        this.tail = new DLLNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addToDLL(DLLNode node){
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    public void deleteFromDLL(DLLNode node){
        DLLNode prev = node.prev;
        DLLNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLLNode node){
        deleteFromDLL(node);
        addToDLL(node);
    }

    public DLLNode popTail(){
        DLLNode res = this.tail.prev;
        deleteFromDLL(res);
        return res;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLLNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        DLLNode node = map.get(key);

        if(node==null){
            DLLNode newNode = new DLLNode(key,value);
            newNode.key = key;
            newNode.value = value;

            map.put(key,newNode);
            addToDLL(newNode);

            this.size++;

            if(this.size>capacity){
                DLLNode tail = popTail();
                map.remove(tail.key);
                this.size--;
            }
        }
        else{
            node.value = value;
            moveToHead(node);
        }
    }
}
