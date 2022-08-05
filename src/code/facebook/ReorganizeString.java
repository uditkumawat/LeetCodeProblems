package code.facebook;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String args[]){

        String s = "aaab";

        ReorganizeString obj = new ReorganizeString();

        System.out.println(obj.reorganizeString(s));
    }
    public String reorganizeString(String s) {

        if(s==null || s.length()==0){
            return "";
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((entry1, entry2)->{
            return entry2.getValue()-entry1.getValue();
        });

        StringBuilder sb = new StringBuilder();

        Map<Character,Integer> map = new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(entry);
        }

        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();

            if(sb.length()>0 && sb.charAt(sb.length()-1)==entry.getKey()){
                return "";
            }
            else{
                sb.append(entry.getKey());
            }

            entry.setValue(entry.getValue()-1);
            if(entry.getValue()>0){
                pq.add(new AbstractMap.SimpleEntry<Character, Integer>(entry.getKey(),entry.getValue()));
            }
        }

        return sb.toString();

    }
}
