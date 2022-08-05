package code.booking.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
//TC- O(NK) ---where N is number of string and K is max length of string
//SC - O(NK)
public class GroupAnagrams {

    public static void main(String args[]){

        String strs[] = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> res = obj.groupAnagrams(strs);

        for(List<String> list:res){
            System.out.println(list);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs==null || strs.length==0){
            return null;
        }

        return groupUtil(strs);
    }

    public List<List<String>> groupUtil(String strs[]){

        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){

            String hash = getHashOfString(str);
            //System.out.println(str+" -> "+hash);
            List<String> list = map.getOrDefault(hash,new ArrayList<>());

            list.add(str);

            map.put(hash,list);
        }

        List<List<String>> res = new ArrayList();

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public String getHashOfString(String str){

        int count[] = new int[26];

        for(char c:str.toCharArray()){
            count[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(count[i]==0){
                sb.append("#");
            }
            else{
                sb.append(count[i]);
            }
        }

        return sb.toString();
    }
}
