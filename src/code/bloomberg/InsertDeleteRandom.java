package code.bloomberg;

import java.util.*;

//TC - O(1)
//SC - O(N)
//https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
public class InsertDeleteRandom {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;
    public InsertDeleteRandom() {
        map = new HashMap();
        list = new ArrayList();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);
        list.set(index,lastElement);
        map.put(lastElement,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
