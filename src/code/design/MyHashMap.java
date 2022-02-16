package code.design;

import java.util.Iterator;
import java.util.LinkedList;

//https://leetcode.com/problems/design-hashmap/
//solution of handling collision
public class MyHashMap {

    class Node{
        int key;
        int value;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public final int BUCKET_SIZE = 100;
    public LinkedList<Node> buckets[];

    public MyHashMap() {

        this.buckets = new LinkedList[BUCKET_SIZE];

        for(int i=0;i<BUCKET_SIZE;i++){
            this.buckets[i] = new LinkedList<Node>();
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Node> list = buckets[index];
        if(get(key)!=-1){
            remove(key);
        }
        Node node = new Node(key,value);
        list.add(node);
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Node> list = buckets[index];
        Iterator<Node> it = list.iterator();
        while(it.hasNext()){
            Node node = it.next();
            if(node.key==key){
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> list = buckets[index];
        Iterator<Node> it = list.iterator();
        while(it.hasNext()){
            Node node = it.next();
            if(node.key==key){
                it.remove();
                break;
            }
        }
    }

    public int hash(int key){
        return key % BUCKET_SIZE;
    }

    public static void main(String args[]){
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));

    }
}
