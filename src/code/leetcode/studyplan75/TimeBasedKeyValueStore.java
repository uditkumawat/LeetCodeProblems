package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/
//TC - O(logn)
//SC - O(logn)
public class TimeBasedKeyValueStore {

    Map<String, TreeMap<Integer,String>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap();
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
        else{
            TreeMap<Integer,String> treeMap = map.get(key);
            if(treeMap.containsKey(timestamp)){
                return treeMap.get(timestamp);
            }
            Map.Entry<Integer,String> entry = treeMap.floorEntry(timestamp);
            return entry!=null?entry.getValue():"";
        }
    }
}
