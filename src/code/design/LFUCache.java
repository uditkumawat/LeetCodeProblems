package code.design;

import java.util.HashMap;
import java.util.Map;

//https://github.com/striver79/SDESheet/blob/main/LFUCacheJava
//https://leetcode.com/problems/lfu-cache/
public class LFUCache {

    class DoublyLinkedList{
        DLLNode head;
        DLLNode tail;
        int size;
        DoublyLinkedList(){
            this.size = 0;
            this.head = new DLLNode();
            this.tail = new DLLNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void removeNode(DLLNode node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            this.size--;
        }

        public void addNode(DLLNode node){
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
            this.size++;
        }
    }

    class DLLNode{
        int key;
        int value;
        int frequency;
        DLLNode prev;
        DLLNode next;
        DLLNode(int key,int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
            this.frequency = 1;
        }
        DLLNode(){

        }
    }

    //map of value with its node reference
    Map<Integer,DLLNode> keyNodeMap;
    //map of frequency with doublyLinkedlist of same frequency
    Map<Integer,DoublyLinkedList> fMap;
    int capacity;
    int minFrequency;

    LFUCache(int capacity){
        this.capacity = capacity;
        this.minFrequency = 0;
        keyNodeMap = new HashMap<>();
        fMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key){
        if(!keyNodeMap.containsKey(key)){
            return -1;
        }
        else{
            DLLNode node = keyNodeMap.get(key);
            updateNode(node);
            return node.value;
        }
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key,int value){
        if(this.capacity==0){
            return;
        }

        if(keyNodeMap.containsKey(key)){
            DLLNode node = keyNodeMap.get(key);
            node.value = value;
            updateNode(node);
        }
        else{
            if(this.keyNodeMap.size()>=this.capacity){
                //remove LRU element from minFrequency
                DoublyLinkedList dll = fMap.get(minFrequency);
                keyNodeMap.remove(dll.tail.prev.key);
                dll.removeNode(dll.tail.prev);
            }

            //as this will be new node so , setting minFreq to 1
            minFrequency = 1;
            DLLNode node = new DLLNode(key,value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoublyLinkedList dll = fMap.getOrDefault(1,new DoublyLinkedList());
            dll.addNode(node);
            fMap.put(1,dll);
            keyNodeMap.put(key,node);
        }
    }

    public void updateNode(DLLNode node){
        int currFreq = node.frequency;
        DoublyLinkedList dll = fMap.get(currFreq);
        dll.removeNode(node);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if(currFreq==minFrequency && dll.size==0){
            minFrequency++;
        }

        node.frequency++;

        DoublyLinkedList newDll = fMap.getOrDefault(node.frequency,new DoublyLinkedList());
        newDll.addNode(node);
        fMap.put(node.frequency,newDll);
    }

    public static void main(String args[]){
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
