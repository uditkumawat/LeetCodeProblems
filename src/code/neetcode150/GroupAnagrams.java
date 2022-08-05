package code.neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
//Tc - O(N)
//SC -O(N)
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s:strs){
            String hash = getHash(s);
            List<String> list = map.getOrDefault(hash,new ArrayList<>());
            list.add(s);
            map.put(hash,list);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public String getHash(String str){
        int count[] = new int[26];

        for(char c:str.toCharArray()){
            count[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<26;i++){
            sb.append(count[i]).append("#");
        }

        return sb.toString();
    }
}
