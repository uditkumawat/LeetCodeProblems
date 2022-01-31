package code.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 * checking the diff between consecutive chars
 * if diff is same , then group them based on hash key
 */
public class GroupShiftedStrings {

    public static void main(String args[]){

        String strings[] = {"abc","bcd","acef","xyz","az","ba","a","z"};

        GroupShiftedStrings obj = new GroupShiftedStrings();

        List<List<String>> res = obj.groupStrings(strings);

        for(List<String> list:res){
            System.out.println(list);
        }
    }
    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> res = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for(String word:strings){
            String key = getKey(word);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(word);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public String getKey(String key){

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<key.length();i++){
            char curr = key.charAt(i);
            char prev = key.charAt(i-1);

            int diff = curr-prev;

            if(diff<0){
                diff+=26;
            }

            sb.append(diff);
            sb.append("#");
        }

        return sb.toString();
    }
}
