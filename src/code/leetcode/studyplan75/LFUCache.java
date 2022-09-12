package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=mzqHlAW7jeE
//https://leetcode.com/problems/lfu-cache/submissions/
public class LFUCache {

    class DLLNode{
        int key;
        int val;
        int freq;
        DLLNode prev;
        DLLNode next;
        DLLNode(int key,int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
            this.freq = 1;
        }
        DLLNode(){

        }
    }

    class DLL{
        DLLNode head;
        DLLNode tail;
        int size;
        DLL(){
            this.head = new DLLNode();
            this.tail = new DLLNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size = 0;
        }

        public void remove(DLLNode node){
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

    Map<Integer,DLL> freqMap;
    Map<Integer,DLLNode> keyMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap();
        this.freqMap = new HashMap();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {

        if(!keyMap.containsKey(key)){
            return -1;
        }
        else{
            DLLNode node = keyMap.get(key);
            updateNode(node);
            return node.val;
        }
    }

    private void updateNode(DLLNode node){
        int currFreq = node.freq;
        DLL dll = freqMap.get(currFreq);
        dll.remove(node);

        if(currFreq==this.minFreq && dll.size==0){
            this.minFreq++;
        }

        node.freq++;

        DLL ndll = freqMap.getOrDefault(node.freq,new DLL());
        ndll.addNode(node);
        freqMap.put(node.freq,ndll);

    }

    public void put(int key, int value) {

        if(this.capacity==0){
            return;
        }
        if(keyMap.containsKey(key)){
            DLLNode node = keyMap.get(key);
            node.val = value;
            updateNode(node);
        }
        else{
            if(this.keyMap.size()>=this.capacity){
                DLL dll = freqMap.get(minFreq);
                keyMap.remove(dll.tail.prev.key);
                dll.remove(dll.tail.prev);
            }

            minFreq = 1;

            DLLNode node = new DLLNode(key,value);

            DLL dll = freqMap.getOrDefault(minFreq,new DLL());
            dll.addNode(node);
            freqMap.put(minFreq,dll);
            keyMap.put(key,node);
        }
    }
}
