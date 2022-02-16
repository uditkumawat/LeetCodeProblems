package code.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/
public class TimeBasedKeyValueStore {

    //treemap is used for having clean code for binary search operation and it puts all keys in sorted manner
    Map<String, TreeMap<Integer,String>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public static void main(String args[]){
        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",3));
        obj.set("foo","bar2",4);
        System.out.println(obj.get("foo",4));
        System.out.println(obj.get("foo",5));

    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap.size()==0){
            return "";
        }

        Integer prevIndexValue = treeMap.floorKey(timestamp);
        if(prevIndexValue==null){
            return "";
        }

        return treeMap.get(prevIndexValue);
    }
}
