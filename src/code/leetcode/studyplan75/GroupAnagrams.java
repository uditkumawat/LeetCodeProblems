package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/submissions/
//TC - O(N*K)
//SC - O(N*K)
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList();

        if(strs==null || strs.length==0){
            return res;
        }

        Map<String,List<String>> map = new HashMap();

        for(String str:strs){

            String hashedValue = getHash(str);
            if(!map.containsKey(hashedValue)){
                map.put(hashedValue,new ArrayList());
            }
            map.get(hashedValue).add(str);
        }

        for(List<String> val:map.values()){
            res.add(val);
        }

        return res;
    }

    public String getHash(String str){

        int count[] = new int[26];

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            count[c-'a']++;
        }



        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count.length;i++){
            sb.append(count[i]).append("#");
        }
        System.out.println(str+" "+sb.toString());
        return sb.toString();
    }
}
