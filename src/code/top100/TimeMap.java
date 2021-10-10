package code.top100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class Data{
        String value;
        int timestamp;
        Data(int timestamp,String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Data>> map;
    TimeMap(){
        map = new HashMap<>();
    }

    public static void main(String args[]){
        TimeMap obj = new TimeMap();
        obj.set("A","B",2);
        System.out.println(obj.get("A",2));
        System.out.println(obj.get("A",3));
        System.out.println(obj.get("A",1));
        obj.set("A","C",5);
        System.out.println(obj.get("A",7));
        System.out.println(obj.get("A",4));

    }

    public void set(String key,String value,int timestamp){
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Data(timestamp,value));
    }

    public String get(String key,int timestamp){
        if(!map.containsKey(key)){
            return "";
        }
        List<Data> list = map.get(key);
        return findFloorWRTTimestamp(list,timestamp);
    }

    public String findFloorWRTTimestamp(List<Data> list,int timestamp){
        int left = 0;
        int right = list.size()-1;
        int res = -1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(list.get(mid).timestamp==timestamp){
                return list.get(mid).value;
            }
            else if(list.get(mid).timestamp<=timestamp){
                res = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return res==-1?"":list.get(res).value;
    }
}
