package code.bloomberg;

import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/

/**
 * Time complexity : O(N)O(N), with NN being the number of operations. All of our operations are O(1)O(1), giving N * O(1) = O(N)N∗O(1)=O(N).
 *
 * Space complexity : O(N)O(N), with NN being the number of operations. The worst case scenario is if we get NN add operations, in which case our ArrayList and our HashMap grow to size NN.
 */
public class InsertDeleteRemoveWithDuplicates {

    List<Integer> list;
    Map<Integer, Set<Integer>> indexes;
    Random rand;
    public InsertDeleteRemoveWithDuplicates() {
        this.list = new ArrayList();
        this.indexes = new HashMap();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        if(!indexes.containsKey(val)){
            indexes.put(val,new LinkedHashSet<Integer>());
        }
        indexes.get(val).add(list.size());
        list.add(val);
        return indexes.get(val).size()==1;
    }

    public boolean remove(int val) {
        if(!indexes.containsKey(val) || indexes.get(val).size()==0){
            return false;
        }

        int removeIndex = indexes.get(val).iterator().next();
        indexes.get(val).remove(removeIndex);
        int last = list.get(list.size()-1);
        list.set(removeIndex,last);
        indexes.get(last).add(removeIndex);
        indexes.get(last).remove(list.size()-1);

        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
