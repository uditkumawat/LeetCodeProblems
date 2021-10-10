package code.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCacheUsingPriorityQueue {

    class Node{
        int key;
        int value;
        int usedCount;
        int timeUsed;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.usedCount = 1;
            this.timeUsed = timestamp++;
        }
        Node(int key,int value,int count){
            this.key = key;
            this.value = value;
            this.usedCount = count+1;
            this.timeUsed = timestamp++;
        }
    }

    private static int timestamp = 0;
    PriorityQueue<Node> pq;
    Map<Integer,Node> nodeMap;
    int capacity;

    LFUCacheUsingPriorityQueue(int capacity){
        this.capacity = capacity;
        this.pq = new PriorityQueue<>((a,b)->{
            return a.usedCount!=b.usedCount ? a.usedCount-b.usedCount : a.timeUsed-b.timeUsed;
        });
        this.nodeMap = new HashMap<>();
    }

    public void put(int key,int value){
        Node node = null;
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            pq.remove(node);
            Node newNode = new Node(key,value,node.usedCount);
            pq.add(newNode);
            nodeMap.put(key,newNode);
        }
        else{
            node = new Node(key,value);
            pq.add(node);
            nodeMap.put(key,node);
        }

        if(pq.size()>this.capacity){
            pq.poll();
        }
    }

    public int get(int key){
        Node node = null;
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            pq.remove(node);
            Node newNode = new Node(node.key,node.value,node.usedCount);
            pq.add(newNode);
            nodeMap.put(key,newNode);
            if(pq.size()>this.capacity){
                pq.poll();
            }
            return node.value;
        }
        else{
            return -1;
        }
    }

}
