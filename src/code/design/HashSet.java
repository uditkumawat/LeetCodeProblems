package code.design;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=NrMaQL_4Npo

/**
 * Time Complexity: \mathcal{O}(\frac{N}{K})O(
 * K
 * N
 * ​
 *  ) where NN is the number of all possible values and KK is the number of predefined buckets, which is 769.
 *
 * Assuming that the values are evenly distributed, thus we could consider that the average size of bucket is \frac{N}{K}
 * K
 * N
 * ​
 *  .
 *
 * Since for each operation, in the worst case, we would need to scan the entire bucket, hence the time complexity is \mathcal{O}(\frac{N}{K})O(
 * K
 * N
 * ​
 *  ).
 *
 * Space Complexity: \mathcal{O}(K+M)O(K+M) where KK is the number of predefined buckets, and MM is the number of unique values that have been inserted into the HashSet.
 */
public class HashSet {

    //it is generally advisable to use a prime number as the base of modulo, e.g. 769769, in order to reduce the potential collisions.
    public final int ARRAY_SIZE = 31;
    public List<List<Integer>> list;

    public HashSet(){
        list = new ArrayList<>(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            list.add(null);
        }
    }

    public void add(int val){
        int hashedIndex = hash(val);
        List<Integer> childList = list.get(hashedIndex);
        if(childList == null){
            childList = new ArrayList<>();
            childList.add(val);
        }
        else{
            if(!childList.contains(val)){
                childList.add(val);
            }
        }
        list.set(hashedIndex,childList);
    }

    public void remove(int val){
        int hashedIndex = hash(val);
        List<Integer> childList = list.get(hashedIndex);
        if(childList!=null){
            childList.remove(Integer.valueOf(val));
        }
    }

    public boolean contains(int val){
        int hashedIndex = hash(val);
        return list.get(hashedIndex)!=null && list.get(hashedIndex).contains(val);
    }
    public int hash(int val){
        return val % ARRAY_SIZE;
    }
}
