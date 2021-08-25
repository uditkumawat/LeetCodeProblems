package code.leetcode.doordash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String args[]){
        LRUCacheClass obj = new LRUCacheClass(3);
        obj.put(1,2);
        System.out.println(obj.get(1));
        obj.put(2,3);
        System.out.println(obj.get(1));
        obj.put(3,4);
        System.out.println(obj.get(1));
        obj.put(4,5);
        System.out.println(obj.get(1));
        obj.put(5,6);
        System.out.println(obj.get(1));

        System.out.println(obj.get(1));
        System.out.println(obj.get(1));

    }

    static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){}
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    static class LRUCacheClass {
        private Map<Integer, Node> map;
        private Node front;
        private Node rear;
        private int cacheSize;
        private int currentSize;

        public LRUCacheClass(int capacity) {
            this.currentSize = 0;
            this.map = new HashMap<>();
            this.cacheSize = capacity;
            this.front = new Node();
            this.rear = new Node();

            this.front.next = this.rear;
            this.rear.prev = this.front;
        }

        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public void addNode(Node node) {

            node.prev = front;
            node.next = front.next;

            front.next.prev = node;
            front.next = node;

        }

        public int get(int key) {

            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNode(node);
                addNode(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addNode(node);
                map.put(key, node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                addNode(node);
                this.currentSize++;
                if (currentSize > this.cacheSize) {
                    Node nodeToDelete = rear.prev;
                    removeNode(nodeToDelete);
                    map.remove(nodeToDelete.key);
                    this.currentSize--;
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
