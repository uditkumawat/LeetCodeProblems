package code.design;

import java.util.*;

//https://www.youtube.com/watch?v=dZv6LnWhv-I
//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteRandomO1 {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand;

    public InsertDeleteRandomO1() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
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

        int valIndex = map.get(val);

        //if that is last value
        if(valIndex==list.size()-1){
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }

        int lastValue = list.get(list.size()-1);
        list.set(valIndex,lastValue);
        list.remove(list.size()-1);
        map.put(lastValue,valIndex);
        return true;
    }

    public int getRandom() {
        int size = list.size();
        int randomIndex = rand.nextInt(size);
        return list.get(randomIndex);
    }

    public static void main(String args[]){
        InsertDeleteRandomO1 obj = new InsertDeleteRandomO1();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
