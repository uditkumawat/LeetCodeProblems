package code.april.challenge;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/design-hashmap/
//TC - O(N/K)
//SC - O(K+M)

/**
 * Time Complexity: for each of the methods, the time complexity is \mathcal{O}(\frac{N}{K})O(
 * K
 * N
 * ​
 *  ) where NN is the number of all possible keys and KK is the number of predefined buckets in the hashmap, which is 31 in our case.
 *
 * In the ideal case, the keys are evenly distributed in all buckets. As a result, on average, we could consider the size of the bucket is \frac{N}{K}
 * K
 * N
 * ​
 *  .
 *
 * Since in the worst case we need to iterate through a bucket to find the desire value, the time complexity of each method is \mathcal{O}(\frac{N}{K})O(
 * K
 * N
 * ​
 *  ).
 *
 * Space Complexity: \mathcal{O}(K+M)O(K+M) where KK is the number of predefined buckets in the hashmap and MM is the number of unique keys that have been inserted into the hashmap.
 */
public class MyHashMap {

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
    class Item<U,V>{
        public U key;
        public V value;
        Item(U key,V value){
            this.key = key;
            this.value = value;
        }
    }

    class Bucket{

        public List<Item<Integer,Integer>> bucket;
        Bucket(){
            bucket = new LinkedList();
        }

        public void put(int key,int value){

            for(Item<Integer,Integer> item:this.bucket){
                if(item.key==key){
                    item.value=value;
                    return;
                }
            }
            Item item = new Item(key,value);
            bucket.add(item);
        }

        public int get(int key){
            for(Item<Integer,Integer> item:this.bucket){
                if(item.key==key){
                    return item.value;
                }
            }
            return -1;
        }

        public void remove(int key){
            for(Item<Integer,Integer> item:this.bucket){
                if(item.key==key){
                    this.bucket.remove(item);
                    break;
                }
            }
        }
    }

    public final int SIZE = 31;
    public Bucket buckets[];
    public MyHashMap() {
        buckets = new Bucket[SIZE];
        for(int i=0;i<SIZE;i++){
            buckets[i] = new Bucket();
        }
    }

    public void put(int key, int value) {
        int index = getHash(key);
        buckets[index].put(key,value);
    }

    public int get(int key) {
        int index = getHash(key);
        return buckets[index].get(key);
    }

    public void remove(int key) {
        int index = getHash(key);
        buckets[index].remove(key);
    }

    public int getHash(int key){
        return key % SIZE;
    }
}
