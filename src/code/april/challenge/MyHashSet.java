package code.april.challenge;

import java.util.LinkedList;

//https://leetcode.com/problems/design-hashset/solution/
//TC - O(N/K) - N is number of possible values and K is number of buckets, it is uniformly distributed then each bucket will be having N/K values
//SC - O(K+M) - K is the number of buckets and M is total possible unique value
public class MyHashSet {

    public static void main(String args[]){

        MyHashSet set = new MyHashSet();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println(set.contains(1));
        System.out.println(set.contains(6));
        System.out.println(set.contains(3));
        System.out.println(set.contains(4));
        set.remove(4);
        System.out.println(set.contains(4));

    }
    class Bucket{
        private LinkedList<Integer> list;

        public Bucket(){
            list = new LinkedList<Integer>();
        }

        public void insert(Integer element){
            int index = list.indexOf(element);
            if(index==-1){
                list.add(element);
            }
        }

        public void remove(Integer element){
            list.remove(element);
        }

        public boolean containsElement(Integer element){
            return (list.indexOf(element)!=-1);
        }
    }


    public final int SIZE = 31;
    public Bucket buckets[];
    public MyHashSet() {
        buckets = new Bucket[SIZE];
        for(int i=0;i<SIZE;i++){
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        return buckets[bucketIndex].containsElement(key);
    }

    public int getBucketIndex(int key){
        return key % SIZE;
    }
}
