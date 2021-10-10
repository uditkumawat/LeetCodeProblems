package code.top100;

import java.util.HashMap;
import java.util.Map;

//Two hashmap and one DLL -
//TC - O(1)
public class LFUCache {

    int minimumFrequency;
    int capacity;
    Map<Integer,Node> nodeMap;
    Map<Integer,DoubleLinkedList> frequencyMap;

    LFUCache(int capacity){
        this.minimumFrequency = 1;
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public static void main(String args[]){
        LFUCache lfu = new LFUCache(3);
        lfu.put(1,1);
        System.out.println(lfu.get(1));
        lfu.put(1,2);
        System.out.println(lfu.get(1));
        lfu.put(1,3);
        System.out.println(lfu.get(1));
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(1));
        lfu.put(4,4);
        System.out.println(lfu.get(2));
        lfu.put(5,5);
        System.out.println(lfu.get(3));

    }

    public int get(int key){
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            incrementFrequency(node);
            return node.value;
        }
        else{
            return -1;
        }
    }

    public void incrementFrequency(Node node){
        int oldFrequency = node.frequency;
        if(frequencyMap.containsKey(oldFrequency)) {
            DoubleLinkedList dll = frequencyMap.get(oldFrequency);
            dll.remove(node);
            if (oldFrequency == minimumFrequency && dll.length == 0) {
                minimumFrequency++;
            }
        }
        int newFrequency = oldFrequency+1;
        node.frequency = newFrequency;
        DoubleLinkedList newNodeDll = frequencyMap.getOrDefault(newFrequency,new DoubleLinkedList());
        newNodeDll.add(node);
        frequencyMap.put(newFrequency,newNodeDll);
    }

    public void put(int key,int value){
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            incrementFrequency(node);
            nodeMap.put(key,node);
        }
        else{
            Node node = new Node(key,value);
            if(nodeMap.size()==this.capacity){
                Node removedLastNode = frequencyMap.get(minimumFrequency).removeLastNode();
                nodeMap.remove(removedLastNode.key);
            }
            incrementFrequency(node);
            nodeMap.put(key,node);
            this.minimumFrequency = 1;
        }
    }

    class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(){}
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.frequency = 0;
        }
    }

    class DoubleLinkedList{
        Node head;
        Node tail;
        int length;

        DoubleLinkedList(){
            this.head = new Node();
            this.tail = new Node();
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.length = 0;
        }

        void add(Node node){

            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;

            length++;
        }

        void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            length--;
        }

        Node removeLastNode(){
            Node tailNode = tail.prev;
            tail = tail.prev;
            return tailNode;
        }
    }
}
